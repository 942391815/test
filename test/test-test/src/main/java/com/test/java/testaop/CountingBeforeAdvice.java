package com.test.java.testaop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by qiaogu on 2017/1/11.
 */
public class CountingBeforeAdvice extends MethodCounter implements MethodBeforeAdvice{
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        count(method);
    }
}
