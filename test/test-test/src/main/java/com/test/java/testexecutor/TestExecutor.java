package com.test.java.testexecutor;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by qiaogu on 2017/7/15.
 */
public class TestExecutor {
    public static void main(String[] args) {
        ExecuteTask executeTask = new ExecuteTask();
        for (int i=0;i<10;i++){
            long start = System.currentTimeMillis();
            System.out.println("第"+i+"轮执行开始");
            executeTask.resetCountDownLatch();
            executeTask.executeTask();
            long end = System.currentTimeMillis();
            System.out.println("第"+i+"轮执行完成耗时"+(end-start));
        }
    }
}
