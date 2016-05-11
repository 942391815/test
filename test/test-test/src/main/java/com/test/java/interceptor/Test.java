package com.test.java.interceptor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Test bean = context.getBean(Test.class);
		bean.test("12","xxxxxxxxx");
	}
	
	@Validator
	public void test(String age,@NotNull String name){
		System.out.println(name);
	}
}
