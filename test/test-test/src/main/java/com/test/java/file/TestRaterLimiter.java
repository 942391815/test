package com.test.java.file;

import com.google.common.util.concurrent.RateLimiter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by qiaogu on 2020/12/15.
 */
public class TestRaterLimiter {
//    public static void main(String[] args) {
//        RateLimiter rateLimiter = RateLimiter.create(1.0);
//
//        System.out.println(rateLimiter.tryAcquire(100));
//        rateLimiter.acquire(5);
//        rateLimiter.acquire(2);
//        rateLimiter.acquire(1);
//    }
    public static void main(String[] args) throws InterruptedException {

        //新建一个每秒限制3个的令牌桶
        RateLimiter rateLimiter = RateLimiter.create(10);
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(100);
        for (int i = 0; i < 10; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    //获取令牌桶中一个令牌，最多等待10秒
                    if (rateLimiter.tryAcquire(1)) {
                        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                    }
                }
            });
        }
        executor.shutdown();
    }
}
