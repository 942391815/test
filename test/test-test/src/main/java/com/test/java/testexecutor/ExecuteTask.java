package com.test.java.testexecutor;

/**
 * Created by qiaogu on 2017/7/15.
 */

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuteTask{
    ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()*2);
    CountDownLatch countDownLatch;
    public void resetCountDownLatch(){
        this.countDownLatch = new CountDownLatch(10);
    }
    public boolean executeTask(){
        for (int i=0;i<10;i++){
            executorService.submit(new Task(countDownLatch));
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("一轮任务执行完成");
        return true;
    }
}
class Task implements Runnable{
    CountDownLatch countDownLatch;
    public Task(){

    }
    public Task(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}