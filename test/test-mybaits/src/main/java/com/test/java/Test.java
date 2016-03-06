package com.test.java;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test {
	// 测试mybatis 调用存储过程
	public static void main(String[] args) throws Exception {
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder()
				.build(Resources.getResourceAsReader("config.xml"));
		SqlSession session = sessionFactory.openSession();
		List<Map> selectList = session.selectList("callProc");
		for(Map each:selectList){
			System.out.println(each);
		}
	}
}
