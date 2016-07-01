package com.test.java.testspring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext( 
                new String[]{"beanDefination.xml" });
		PersonService personService = (PersonService)context.getBean("personService");
		System.out.println(personService.getName());
	}
}
