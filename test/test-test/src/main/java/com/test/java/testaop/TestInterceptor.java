package com.test.java.testaop;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by qiaogu on 2017/1/11.
 */
public class TestInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("想嘻嘻嘻嘻嘻嘻嘻嘻嘻");
        return null;
    }
}
