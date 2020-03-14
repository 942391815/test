package com.test.java.single;

/**
 * Created by Micheal on 2020/3/13.
 */
public class ThreadTest {
    public static void main(String[] args) {
        PrintClass printClass = new PrintClass();
        new Thread(new PrintThread(printClass,3)).start();
        new Thread(new PrintThread(printClass,4)).start();
        new Thread(new PrintThread(printClass,2)).start();
        new Thread(new PrintThread(printClass,1)).start();
    }
}
