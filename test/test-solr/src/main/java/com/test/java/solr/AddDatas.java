package com.test.java.solr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddDatas {
	public static List<Map<String, String>> getDatas() {
		List<Map<String,String>> result = new ArrayList<Map<String,String>>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/test";
			String user = "root";
			String password = "123";
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			String sql = "select t.id,t.PROJECT_NUMBER,t.project_name,t.TENDER_NAMES,t.TENDERINGS,t.REGION,t.PROCESS_INSTANCE_ID,t.PROJECT_AMOUNT_RMB from proj_inter_project t";
//			String sql = "select t.PROJECT_ID,t.FILE_TYPE,t.REMARK from proj_file_info t ";
//			String sql = "select ";s
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("id", rs.getString("id"));
				map.put("project_number", rs.getString("PROJECT_NUMBER"));
				map.put("project_name", rs.getString("project_name"));
				map.put("tender_names", rs.getString("TENDER_NAMES"));
				map.put("tender_ids", rs.getString("TENDERINGS"));
				map.put("region", rs.getString("REGION"));
				map.put("process_instance_id",
						rs.getString("PROCESS_INSTANCE_ID"));
				map.put("project_amount_rmb",
						rs.getString("PROJECT_AMOUNT_RMB"));
				
//				map.put("project_id", rs.getString("PROJECT_ID"));
//				map.put("file_type", rs.getString("FILE_TYPE"));
//				map.put("remark", rs.getString("REMARK"));
				
				result.add(map);
			}
			}catch (Exception ex) {
			// 显示数据库连接错误或查询错误
			System.err.println("SQLException:" + ex.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (Exception e) {
				System.err.println("SQLException:" + e.getMessage());
			}
		}
		return result;
	}
}
