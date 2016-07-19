package com.test.java.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
 
import org.apache.ibatis.builder.StaticSqlSource;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.jdbc.ConnectionLogger;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.transaction.Transaction;
 
@Intercepts({ @Signature(type = Executor.class, method = "query", args = { MappedStatement.class, Object.class,
        RowBounds.class, ResultHandler.class }) })
public class PagingInterceptor implements Interceptor {
    HashMap<String, String> map_statement = new HashMap<String, String>();
    static final String COUNT_ID = "_count";
 
    protected synchronized void initStatementMap(Configuration configuration) {
        if (!map_statement.isEmpty()) {
            return;
        }
        Collection<String> statements = configuration.getMappedStatementNames();
        for (Iterator<String> iter = statements.iterator(); iter.hasNext();) {
            String element = iter.next();
            map_statement.put(element, element);
        }
    }

    protected Connection getConnection(Transaction transaction, Log statementLog) throws SQLException {
        Connection connection = transaction.getConnection();
        if (statementLog.isDebugEnabled()) {
            return ConnectionLogger.newInstance(connection, statementLog, 0);
        } else {
            return connection;
        }
    }
 
    public Object intercept(Invocation invocation) throws Throwable {
        Object parameter = invocation.getArgs()[1];
        Page page = seekPage(parameter);
        if (page == null) {
            return invocation.proceed();
        } else {
            return handlePaging(invocation, parameter, page);
        }
 
    }
 
    protected List handlePaging(Invocation invocation, Object parameter, Page page) throws Exception {
        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        Configuration configuration = mappedStatement.getConfiguration();
        if (map_statement.isEmpty()) {
            initStatementMap(configuration);
        }
        BoundSql boundSql = mappedStatement.getBoundSql(parameter);
        StaticSqlSource sqlsource = new StaticSqlSource(configuration, getLimitString(boundSql.getSql(), page),
                boundSql.getParameterMappings());
        MappedStatement.Builder builder = new MappedStatement.Builder(configuration, "id_temp_result", sqlsource,
                SqlCommandType.SELECT);
        builder.resultMaps(mappedStatement.getResultMaps()).resultSetType(mappedStatement.getResultSetType())
                .statementType(mappedStatement.getStatementType());
        MappedStatement query_statement = builder.build();
 
        List data = (List) exeQuery(invocation, query_statement);
        page.setRecords(data);
        page.setCount(getTotalSize(invocation, configuration, mappedStatement, boundSql, parameter));
 
        return data;
    }
 
    protected Object exeQuery(Invocation invocation, MappedStatement query_statement) throws Exception {
        Object[] args = invocation.getArgs();
        return invocation.getMethod().invoke(invocation.getTarget(),
                new Object[] { query_statement, args[1], args[2], args[3] });
    }
 
    protected int getTotalSize(Invocation invocation, Configuration configuration, MappedStatement mappedStatement,
            BoundSql boundSql, Object parameter) throws Exception {
 
        String count_id = mappedStatement.getId() + COUNT_ID;
        int totalSize = 0;
        if (map_statement.containsKey(count_id)) {
            List data = (List) exeQuery(invocation, mappedStatement.getConfiguration().getMappedStatement(count_id));
            if (data.size() > 0) {
                totalSize = Integer.parseInt(data.get(0).toString());
            }
        } else {
            Executor exe = (Executor) invocation.getTarget();
            Connection connection = getConnection(exe.getTransaction(), mappedStatement.getStatementLog());
            String countSql = getCountSql(boundSql.getSql());
            totalSize = getTotalSize(configuration, mappedStatement, boundSql, countSql, connection, parameter);
        }
 
        return totalSize;
    }
 
    protected String getLimitString(String sql, Page page) {
        StringBuffer sb = new StringBuffer(sql.length() + 100);
        sb.append(sql);
        sb.append(" limit ").append(page.getStartNo() - 1).append(",").append(page.getPageSize());
        return sb.toString();
    }
    protected String getCountSql(String sqlPrimary) {
        String sqlUse = sqlPrimary.replaceAll("[\\s]+", " ");
        String upperString = sqlUse.toUpperCase();
        int order_by = upperString.lastIndexOf(" ORDER BY ");
        if (order_by > -1) {
            sqlUse = sqlUse.substring(0, order_by);
        }
        String[] paramsAndMethod = sqlUse.split("\\s");
        int count = 0;
        int index = 0;
        for (int i = 0; i < paramsAndMethod.length; i++) {
            String upper = paramsAndMethod[i].toUpperCase();
            if (upper.length() == 0) {
                continue;
            }
            if (upper.contains("SELECT")) {
                count++;
            } else if (upper.contains("FROM")) {
                count--;
            }
            if (count == 0) {
                index = i;
                break;
            }
        }
        StringBuilder return_sql = new StringBuilder("SELECT COUNT(1) AS cnt ");
        StringBuilder common_count = new StringBuilder();
        for (int j = index; j < paramsAndMethod.length; j++) {
            common_count.append(" ");
            common_count.append(paramsAndMethod[j]);
        }
        if (upperString.contains(" GROUP BY ")) {
            throw new RuntimeException("��֧��group by ��ҳ,�������ṩsql����� ��ѯ���+_count��β.");
        }
        return return_sql.append(common_count).toString();
    }
 
    protected int getTotalSize(Configuration configuration, MappedStatement mappedStatement, BoundSql boundSql,
            String countSql, Connection connection, Object parameter) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int totalSize = 0;
        try {
            ParameterHandler handler = configuration.newParameterHandler(mappedStatement, parameter, boundSql);
            stmt = connection.prepareStatement(countSql);
            handler.setParameters(stmt);
            rs = stmt.executeQuery();
            if (rs.next()) {
                totalSize = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            if (rs != null) {
                rs.close();
                rs = null;
            }
            if (stmt != null) {
                stmt.close();
                stmt = null;
            }
        }
        return totalSize;
    }
 
    protected Page seekPage(Object parameter) {
        Page page = null;
        if (parameter == null) {
            return null;
        }
        if (parameter instanceof Page) {
            page = (Page) parameter;
        } else if (parameter instanceof Map) {
            Map map = (Map) parameter;
            for (Object arg : map.values()) {
                if (arg instanceof Page) {
                    page = (Page) arg;
                }
            }
        }
        return page;
    }
 
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }
 
    public void setProperties(Properties properties) {
    }
}
