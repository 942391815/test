//package com.test.java.log4j;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.log4j.MDC;
//import org.hibernate.engine.query.spi.sql.NativeSQLQueryReturn;
//
///**
// * @Date 2020/8/26 11:31
// * @Created by qiaogu
// */
//@Slf4j
//public class Test {
//    public static void main(String[] args) {
//        MDC.clear();
//        MDC.put("sessionId" , "f9e287fad9e84cff8b2c2f2ed92adbe6");
//        MDC.put("cityId" , 1);
//        MDC.put("siteName" , "北京");
//        MDC.put("userName" , "userwyh");
//        logger.info("测试MDC打印一");
//
//        MDC.put("mobile" , "110");
//        NativeSQLQueryReturn.TraceLogger.info("测试MDC打印二");
//
//        MDC.put("mchId" , 12);
//        MDC.put("mchName", "商户名称");
//        TraceLogger.info("测试MDC打印三");
//    }
//}
