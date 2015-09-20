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
		           //��һ��������MySQL��JDBC������
		              Class.forName("com.mysql.jdbc.Driver"); 
		            //ȡ�����ӵ� url,�ܷ���MySQL���ݿ���û���,���룻���ݿ���
		           String url = "jdbc:mysql://localhost:3306/test";
		           String user = "root";
		           String password = "123";
		         //�ڶ�����������MySQL���ݿ���������ʵ��
		           conn = DriverManager.getConnection(url, user, password);
		         //����������conn����Statement������ʵ�� stmt
		           stmt = conn.createStatement();
		         //���Ĳ���ִ�в�ѯ����ResultSet��Ķ��󣬷��ز�ѯ�Ľ��
		           String sql = "select t.PROJECT_NUMBER,t.project_name,t.TENDER_NAMES,t.TENDERINGS,t.REGION,t.PROCESS_INSTANCE_ID,t.PROJECT_AMOUNT_RMB from proj_inter_project t";
		           rs = stmt.executeQuery(sql);
		           while(rs.next()){
		            System.out.println(rs.getString("id"));      //ȡ�����ݿ��е�����
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
		         //����JDBC����,��Ҫ�õ�����û���ҵ�
		          System.out.println("�������ش���");
		   }catch (SQLException ex) {
		     //��ʾ���ݿ����Ӵ�����ѯ����
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
