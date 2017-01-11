package com.test.java.testaop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by qiaogu on 2017/1/11.
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("application-aop.xml");
        PersonService personService = (PersonService)ac.getBean("testAop");
        personService.showName();
    }
}
