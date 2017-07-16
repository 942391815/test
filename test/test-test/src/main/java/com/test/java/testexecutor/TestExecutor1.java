package com.test.java.testexecutor;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by qiaogu on 2017/7/15.
 */
public class TestExecutor1 {
    public static void main(String[] args) {
        ExecutorTask1 executeTask = new ExecutorTask1();
        for (int i=0;i<10;i++){
            long start = System.currentTimeMillis();
            System.out.println("第"+i+"轮执行开始");
            executeTask.executeTask(i);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
