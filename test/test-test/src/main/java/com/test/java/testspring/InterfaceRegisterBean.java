package com.test.java.testspring;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class InterfaceRegisterBean<T> implements FactoryBean<T>{
	private Class clazz;
	public Class getClazz() {
		return clazz;
	}
	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}
	@Override
	public T getObject() throws Exception {
		BeanProxy bean = new BeanProxy();
		return (T)bean.getProxy(clazz);
	}
	@Override
	public Class<?> getObjectType() {
		return clazz;
	}
	@Override
	public boolean isSingleton() {
		return true;
	}
}
