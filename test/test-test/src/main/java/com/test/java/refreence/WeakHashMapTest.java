package com.test.java.refreence;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * Created by Micheal on 2019/8/16.
 */
public class WeakHashMapTest {

    private static Map<String,byte[]> caches=new WeakHashMap<>();

    public static void main(String[]args) throws InterruptedException {
        for (int i=0;i<100000;i++){
            caches.put(i+"",new byte[1024*1024*10]);
            System.out.println("put num: " + i + " but caches size:" + caches.size());
        }
    }
}