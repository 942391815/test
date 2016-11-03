package com.test.java.spring.beaninit;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class CommonServiceFactoryBean implements FactoryBean {

	@Override
	public Object getObject() throws Exception {
		Class [] interfaces = CommonService.class.getInterfaces();
		ClassLoader classLoader = CommonService.class.getClassLoader();
		InvocationHandler handler = new InvocationHandler(){
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				return new Object();
			}
			
		};
		return Proxy.newProxyInstance(classLoader, interfaces,handler);
	}

	@Override
	public Class getObjectType() {
		return null;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
}
