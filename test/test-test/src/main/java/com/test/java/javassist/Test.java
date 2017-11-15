package com.test.java.javassist;

import javassist.ClassPool;
import javassist.CtClass;

/**
 * Created by qiaogu on 2017/11/10.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("com.test.java.interceptor.ValidationException");
        cc.setSuperclass(pool.get("com.test.java.interceptor.ValidatorInterceptor"));
        cc.writeFile("c://");
    }
}
