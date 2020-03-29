package com.test.java.algorithm.find.test;

import java.util.LinkedHashMap;
import java.util.Map;

public class Three {
    public static void main(String[] args) {
        int size = 4;
        LinkedHashMap map = new LinkedHashMap<Object, Object>(4, .75F, true) {
            private static final long serialVersionUID = 4267176411845948333L;

            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > size;
            }
        };
        map.put("a", "a");
        map.put("b", "b");
        map.put("c", "c");
        map.put("d", "d");
        System.out.println(map.keySet());
        map.put("e", "e");
        System.out.println(map.keySet());
    }
}
