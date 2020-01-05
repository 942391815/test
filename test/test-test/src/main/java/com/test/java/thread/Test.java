package com.test.java.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by qiaogu on 2019/12/30.
 */
public class Test {
    public static void main(String[] args) {

//        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
//        System.out.println("---------------newSingleThreadExecutor--------------");
//        for (int i = 0; i < 200; i++) {
//            final int index = i;
//            newSingleThreadExecutor.execute(new ThreadPoolUtil(index));
//        }


//        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(1);
//        System.out.println("------------newFixedThreadPool-------------");
//        for (int i = 0; i < 1000; i++) {
//            final int index = i;
//            newFixedThreadPool.execute(new ThreadPoolUtil(index));
//        }


//        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(1);
//        System.out.println("------------newFixedThreadPool-------------");
//        for (int i = 0; i < 60; i++) {
//            final int index = i;
//            newFixedThreadPool.execute(() -> {
//                if (index == 20) {
//                    throw new IllegalStateException("Error");
//                }
//                System.out.println(Thread.currentThread() + ".." + index);
//            });
//        }


        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        System.out.println("---------------newSingleThreadExecutor--------------");
        for (int i = 0; i < 60; i++) {
            final int index = i;
            newSingleThreadExecutor.execute(() -> {
                if (index == 20) {
                    throw new IllegalStateException("Error");
                }
                System.out.println(Thread.currentThread() + ".." + index);
            });
        }
    }
}