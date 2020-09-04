package com.test.java.test;

import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test {
	public static void main(String[] args) throws Exception {
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder()
				.build(Resources.getResourceAsReader("config.xml"));
		SqlSession session = sessionFactory.openSession();
		User user = new User();
		user.setName("lisi");
//		user.setId(1);
//		user.setTableName("t_user");
//		List<Object> objects = session.selectList("com.test.java.User.selectById", user);
//		System.out.println(objects);

		int insert = session.insert("com.test.java.User.insert",user);
		System.out.println(user.getId());
		session.commit();
	}
}
