package com.test.java.algorithm.code.others;


import java.util.*;

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

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("a", "a");
        map.put("1", "1");
        map.put("b", "b");

        Set<Map.Entry<String, String>> entries = map.entrySet();
        List<Map.Entry<String, String>> result = new ArrayList<>(entries);
        Collections.sort(result, new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        System.out.println(result);
    }
}
