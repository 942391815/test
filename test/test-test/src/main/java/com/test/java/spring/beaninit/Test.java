package com.test.java.spring.beaninit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("initBean.xml");
		PersonService bean = (PersonService)ac.getBean("personService");
		bean.getAge();
	}
}


// spring bean 的声明周期及接口顺序
/**
	先调用bean 的构造方法进行初始化，然后set相应的属性。 然后调用 postProcessBeforeInitialization
	---》》调用InitializingBean 的afterPropertiesSet方法，最后 postProcessAfterInitialization

**/