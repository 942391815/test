package com.test.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
	 public static void main(String[] args) {
		 List<Map> result = new ArrayList<Map>();
		 Map<String,String> map = new HashMap<String,String>();
		   Connection conn = null;
		   Statement stmt = null;
		   ResultSet rs = null;
		         try {
//		        	 select t.PROJECT_NUMBER,t.project_name,t.TENDER_NAMES,t.TENDERINGS,t.REGION,t.PROCESS_INSTANCE_ID,t.PROJECT_AMOUNT_RMB from proj_inter_project t
		           //第一步：加载MySQL的JDBC的驱动
		              Class.forName("com.mysql.jdbc.Driver"); 
		            //取得连接的 url,能访问MySQL数据库的用户名,密码；数据库名
		           String url = "jdbc:mysql://localhost:3306/test";
		           String user = "root";
		           String password = "123";
		         //第二步：创建与MySQL数据库的连接类的实例
		           conn = DriverManager.getConnection(url, user, password);
		         //第三步：用conn创建Statement对象类实例 stmt
		           stmt = conn.createStatement();
		         //第四步：执行查询，用ResultSet类的对象，返回查询的结果
		           String sql = "select t.PROJECT_NUMBER,t.project_name,t.TENDER_NAMES,t.TENDERINGS,t.REGION,t.PROCESS_INSTANCE_ID,t.PROJECT_AMOUNT_RMB from proj_inter_project t";
		           rs = stmt.executeQuery(sql);
		           while(rs.next()){
		            System.out.println(rs.getString("id"));      //取得数据库中的数据
		            System.out.println(rs.getString("desc"));
		            map.put("project_number", rs.getString("PROJECT_NUMBER"));
		            map.put("project_name", rs.getString("project_name"));
		            map.put("tender_names", rs.getString("TENDER_NAMES"));
		            map.put("tender_ids", rs.getString("TENDERINGS"));
		            map.put("region", rs.getString("REGION"));
		            map.put("process_instance_id", rs.getString("PROCESS_INSTANCE_ID"));
		            map.put("project_amount_rmb", rs.getString("PROJECT_AMOUNT_RMB"));
		           }
		         } catch (ClassNotFoundException e) {  
		         //加载JDBC错误,所要用的驱动没有找到
		          System.out.println("驱动加载错误");
		   }catch (SQLException ex) {
		     //显示数据库连接错误或查询错误
		     System.err.println("SQLException:"+ex.getMessage());
		   }finally {
		         try{
		          if(rs != null) {
		           rs.close();
		           rs = null;
		          }
		          if(stmt != null) {
		           stmt.close();
		           stmt = null;
		          }
		          if(conn != null) {
		           conn.close();
		           conn = null;
		          }
		         }catch(SQLException e) {
		          System.err.println("SQLException:"+e.getMessage());
		         }
		   }
		 }
}
