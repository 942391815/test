package com.test.java.testexecutor;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by qiaogu on 2017/7/16.
 */
public class ExecutorTask1 {
    ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public boolean executeTask(final int round) {
        //调用提交两个请求，一次执行2s一个执行5s
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    System.out.println("第"+round+"  2s 任务执行完成");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(18000);
                    System.out.println("第"+round+"  5s 任务执行完成");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        return true;
    }
}