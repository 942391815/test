//package com.test.java.commonrpc;
//
//public class Test {
//	 ClassPathXmlApplicationContext context =new ClassPathXmlApplicationContext("CommonRpcClient.xml");
//	    IDemoService demoService=(IDemoService) context.getBean("demoServiceClient");
//	    long time1=System.currentTimeMillis();
//	    for(int i=0;i<1;i++){
//	        String result=demoService.sayDemo("okok");
//	        System.out.println(result);
//	    }
//
//	    long end1=System.currentTimeMillis();
//	    System.out.println("完成时间1:"+(end1-time1));
//	}
//}
