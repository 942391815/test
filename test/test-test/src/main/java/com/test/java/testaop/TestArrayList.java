package com.test.java.testaop;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by qiaogu on 2017/7/20.
 */
public class TestArrayList {

    public static void main(String[] args) {
        final List arrayList = new ArrayList();
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<100;i++){
                    arrayList.add(i);
                }
                countDownLatch.countDown();
            }
        });
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<100;i++){
                    arrayList.add(i);
                }
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
            for(int i=0;i<arrayList.size();i++){
                System.out.println(arrayList.get(i));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}