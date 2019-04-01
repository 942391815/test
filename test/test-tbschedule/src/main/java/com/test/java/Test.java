//package com.test.java;
//
//import com.taobao.pamirs.schedule.strategy.TBScheduleManagerFactory;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import java.util.Properties;
//
///**
// * Created by qiaogu on 2016/10/21.
// */
//public class Test {
//    public static void main(String[] args) throws Exception{
//        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
////        applicationContext.start();
////        applicationContext.getBean("iScheduleTaskDealSingleTest");
////        Thread.sleep(Integer.MAX_VALUE);
//        TBScheduleManagerFactory scheduleManagerFactory = new TBScheduleManagerFactory();
//
//        Properties p = new Properties();
//        p.put("zkConnectString", "localhost:2181");
//        p.put("rootPath", "/tbSchedule/Test");
//        p.put("zkSessionTimeout", "60000");
//        p.put("userName", "zookeeper");
//        p.put("password", "zookeeper");
//        p.put("isCheckParentPath", "true");
//
//        scheduleManagerFactory.setApplicationContext(applicationContext);
//
//        scheduleManagerFactory.init(p);
//    }
//}
