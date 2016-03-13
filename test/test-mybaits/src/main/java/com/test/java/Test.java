package com.test.java;

import java.util.HashMap;
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
		Map map = new HashMap();
		map.put("queryStart", 10);
		map.put("queryEnd", 10);
		List<Map> selectList = session.selectList("callProc",map);
		for(Map each:selectList){
			System.out.println(each);
		}
	}
}
