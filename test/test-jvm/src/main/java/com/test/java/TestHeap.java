package com.test.java;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Micheal on 2016/11/13.
 * -Xmx20m -Xms5m -XX:+PrintGCDetails 参数配置
 */
public class TestHeap {

    public static void main(String[] args) {
        Map<Object,String> map = new HashMap<Object,String>();
        String name = "sssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "dddddddddddddddddddddddddddddddddddddddd" +
                "ww333333333333333333333333333333333333333333333333333" +
                "3333333333333333333333333333333333333333333331111111111111111111111111111111111111111" +
                "111111111111111111111111111111s";
        for (int i=0;i<100000000000L;i++){
            map.put(new Object(),name);
        }
        System.out.println(12);
    }
}
