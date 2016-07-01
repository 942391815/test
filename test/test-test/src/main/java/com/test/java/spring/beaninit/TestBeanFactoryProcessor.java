package com.test.java.spring.beaninit;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class TestBeanFactoryProcessor implements BeanFactoryPostProcessor{
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println(beanFactory);
//		BeanDefinition bd = beanFactory.getBeanDefinition("personService");
//		bd.setAttribute("commonService", Proxy.newProxyInstance(CommonService.class.getClassLoader(), CommonService.class.getInterfaces(), 
//				new InvocationHandler() {
//					@Override
//					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//						return null;
//					}
//				}));
	}
}
