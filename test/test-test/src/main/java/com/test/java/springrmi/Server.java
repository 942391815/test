package com.test.java.springrmi;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by qiaogu on 2017/5/9.
 */
public class Server {
    public static void main(String[] args) throws InterruptedException {
        new ClassPathXmlApplicationContext("spring-rmi-server.xml");
        Object lock = new Object();
        synchronized (lock) {
            lock.wait();
        }
    }
}
