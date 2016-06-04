package com.test.java.testspring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext( 
                new String[]{"beanDefination.xml" });
		Person bean = (Person)context.getBean("person");
		System.out.println(bean.getName()+"---"+bean.getAge());
	}
}
