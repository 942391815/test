package com.test.java.single;

/**
 * Created by Micheal on 2020/3/13.
 */
public class SingleInstance {
    private SingleInstance() {
    }

    private static class SingleInstanceHolder {
        private static SingleInstance instance = new SingleInstance();
    }

    public static SingleInstance getInstance() {
        return SingleInstanceHolder.instance;
    }
}
