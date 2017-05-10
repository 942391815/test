package com.test.java.springrmi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by qiaogu on 2017/5/9.
 */
public class RmiClient {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "spring-rmi-client.xml");
        AccountService accountService = (AccountService) ctx
                .getBean("mobileAccountService");
        String result = accountService.shoopingPayment("13800138000", (byte) 5);
    }
}
