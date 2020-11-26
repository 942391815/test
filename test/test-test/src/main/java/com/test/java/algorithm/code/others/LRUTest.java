package com.test.java.algorithm.code.others;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Micheal on 2020/11/26.
 */
public class LRUTest<K, V> extends LinkedHashMap<K, V> {
    private Integer cacheSize;

    public LRUTest(Integer cacheSize) {
        super(16, 0.75f, true);
        this.cacheSize = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > cacheSize;
    }
}
