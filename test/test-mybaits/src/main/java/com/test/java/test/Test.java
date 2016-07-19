package com.test.java.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test {
	public static void main(String[] args) throws Exception {
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder()
				.build(Resources.getResourceAsReader("config.xml"));
		SqlSession session = sessionFactory.openSession();
		List pks = new ArrayList();
		pks.add("002885c8a54e11e598bcfa163e84de1b");
		pks.add("002d406b4b644759a2301f0498686621");
		List<String> selectList = session.selectList("getMD5sByPks", pks);
		for(String each:selectList){
			System.out.println(each);
		}
	}
}
