package com.test.java.test;

/**
 * Created by qiaogu on 2017/8/7.
 */
public class Test {
    protected static class Children {
        public static void test() {

        }
    }

    public static Children getChildren() {
        return new Children();
    }

    public static void main(String[] args) {
        Thread.currentThread().interrupt();
        System.out.println(123123123);
    }
}
