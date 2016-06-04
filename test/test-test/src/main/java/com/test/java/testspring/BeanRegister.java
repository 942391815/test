package com.test.java.testspring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class BeanRegister implements ApplicationContextAware,InitializingBean{
	private ApplicationContext applicationContext;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		ConfigurableApplicationContext configurableApplicationContext  = (ConfigurableApplicationContext)applicationContext;
		DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory)configurableApplicationContext.getBeanFactory();
		RootBeanDefinition beanDefinition = new RootBeanDefinition();
        beanDefinition.setBeanClass(Person.class);
        beanDefinition.setLazyInit(false);
        beanDefinition.getPropertyValues().add("name","zhangsan");
        beanDefinition.getPropertyValues().add("age",20);
		beanFactory.registerBeanDefinition("person", beanDefinition);
	}
}
