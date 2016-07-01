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


// spring bean ���������ڼ��ӿ�˳��
/**
	�ȵ���bean �Ĺ��췽�����г�ʼ����Ȼ��set��Ӧ�����ԡ� Ȼ����� postProcessBeforeInitialization
	---��������InitializingBean ��afterPropertiesSet��������� postProcessAfterInitialization

**/