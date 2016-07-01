package com.test.java.testdubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Server {
	   public static void main(String[] args) throws Exception { 
	        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext( 
	                new String[]{"server.xml" }); 
	        context.start();
	        System. out.println("Press any key to exit." ); 
	        System. in.read(); 
	    } 

}
