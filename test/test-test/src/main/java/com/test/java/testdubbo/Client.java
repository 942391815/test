package com.test.java.testdubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext( 
                new String[]{"client.xml" }); 
        context.start(); 
        IProcessData demoService = (IProcessData) context.getBean("demoService" ); // get 
        String hello = demoService.deal( "nihao"); // do invoke! 
        System.out.println(Thread.currentThread().getName() + " "+hello); 

	}
}
