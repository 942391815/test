package com.test.java.algorithm.code.others;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUTestV2 extends LinkedHashMap<String, String> {
    private int cacheSize;

    public LRUTestV2(int cacheSize) {
        this.cacheSize = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
        return size() > cacheSize;
    }

    public static void main(String[] args) {
        LRUTestV2 test = new LRUTestV2(3);
        test.put("12", "12");
        test.put("13", "13");
        test.put("14", "14");
        test.put("15", "15");
        System.out.println(test);
    }

//    public void quickSort()
}
