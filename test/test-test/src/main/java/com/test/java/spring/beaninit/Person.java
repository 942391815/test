package com.test.java.spring.beaninit;

import org.springframework.beans.factory.InitializingBean;

public class Person implements InitializingBean{
	
	private String name;
	
	public Person(){
		System.out.println("1");
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println(2);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		System.out.println("set name");
		this.name = name;
	}
}
