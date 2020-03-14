package com.test.java.lock;

import java.util.Random;

/**
 * Created by Micheal on 2020/3/14.
 */
public class TestBlockQueue {
    public static void main(String[] args) {
        MyBlockQueue blockQueue = new MyBlockQueue();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Random random = new Random();
                    int num = random.nextInt(20000);
                    blockQueue.put(num + "");
                    System.out.println("放入数据" + num);
//                    try {
//                        Thread.sleep(3000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("获取数据" + blockQueue.get());
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
