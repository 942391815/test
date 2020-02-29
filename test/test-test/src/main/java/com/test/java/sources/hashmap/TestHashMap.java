package com.test.java.sources.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Micheal on 2020/2/19.
 */
public class TestHashMap {
    public static void main(String[] args) {
//        Map<String, String> map = new HashMap(10, 0.8f);
//        map.put("12", "12");
//        System.out.println(map);
        System.out.println(5 & 4);
        System.out.println((5 & 4));
        System.out.println(5 & 8);
        System.out.println((5 & 8));
        System.out.println((5 & 4) == 0);
        System.out.println((5 & 8) == 0);
        int n = 16;
        int sc = n - (n >>> 2);
        System.out.println(sc);

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(8);
        concurrentHashMap.put("12",12);
        HashMap map = new HashMap(7);
        map.put(121,12);

    }
}
