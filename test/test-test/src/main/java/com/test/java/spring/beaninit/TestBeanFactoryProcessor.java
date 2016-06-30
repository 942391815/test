package com.test.java.spring.beaninit;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

public class TestBeanFactoryProcessor implements BeanFactoryPostProcessor{
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		
		RootBeanDefinition rd = new RootBeanDefinition();
		rd.set
			
//		beanFactory.registerSingleton("commonService",);
//		beanFactory.registerSingleton(beanName, singletonObject);
	}
}
