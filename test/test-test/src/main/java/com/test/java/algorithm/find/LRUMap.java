//package com.test.java.algorithm.find;
//
//import java.util.LinkedHashMap;
//
///**
// * Created by Micheal on 2020/3/24.
// */
//public class LRUMap<K,V> extends LinkedHashMap {
//
//    public LRUMap(int thr) {
//        super(16, 0.75f, true);
//        this.THRESHOLD = thr;
//    }
//
//    @Override
//    protected boolean removeEldestEntry(java.util.Map.Entry eldest)
//    {
//        return size() > THRESHOLD;
//    }
//
//    @Override
//    public Object get(Object key) {
//        Object o = super.get(key);
//
//        if (o == null){
//            return -1;
//        }
//        return o;
//    }