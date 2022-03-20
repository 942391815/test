package com.test.java.redission;

import org.redisson.Config;
import org.redisson.Redisson;
import org.redisson.RedissonClient;
import org.redisson.core.RLock;

import java.util.concurrent.TimeUnit;

/**
 * Created by Micheal on 2020/3/6.
 */
public class Test {
    static String host = "127.0.0.1";
    static String port = "6379";

    public static void main(String[] args) throws InterruptedException {

        Config config = new Config();
        //单机模式  依次设置redis地址和密码
        config.useSingleServer().setAddress("127.0.0.1:6379");
        RedissonClient client = Redisson.create(config);
        System.out.println("获取成功");
        Thread.sleep(Integer.MAX_VALUE);

    }
}
