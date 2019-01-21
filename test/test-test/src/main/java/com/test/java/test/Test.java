package com.test.java.test;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by qiaogu on 2017/8/7.
 */
public class Test {
    public static void main(String[] args) {
        ConcurrentHashMap<String,String> curr = new ConcurrentHashMap<>();
        curr.put("aa","bb");
        System.out.println(curr.putIfAbsent("aa","cc"));
        System.out.println(curr.putIfAbsent("dd","cc"));
        System.out.println(curr.putIfAbsent("dd","cc"));

    }
}
