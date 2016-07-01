package com.test.java.testspring;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BeanProxy<T> implements InvocationHandler{
	@SuppressWarnings("unchecked")
	public <T> T getProxy(Class<T> clazz){
		//此方法为创建代理对象
		return (T) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getClass().getInterfaces(), this);
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println(456);
		return null;
	}
}
