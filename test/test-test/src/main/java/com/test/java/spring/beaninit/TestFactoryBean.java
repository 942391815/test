package com.test.java.spring.beaninit;

import org.springframework.beans.factory.FactoryBean;

public class TestFactoryBean implements FactoryBean{
	@Override
	public Object getObject() throws Exception {
		System.out.println(123);
		return null;
	}

	@Override
	public Class getObjectType() {
		return null;
	}
	@Override
	public boolean isSingleton() {
		return false;
	}
}
