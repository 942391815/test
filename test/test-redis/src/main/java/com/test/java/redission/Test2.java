package com.test.java.redission;

import org.redisson.Config;
import org.redisson.Redisson;
import org.redisson.RedissonClient;
import org.redisson.core.RLock;
import redis.clients.jedis.Jedis;

/**
 * Created by Micheal on 2020/3/6.
 */
public class Test2 {
    static String host = "127.0.0.1";
    static String port = "6379";

    public static void main(String[] args) throws InterruptedException {

        Jedis jedis = new Jedis("localhost");
        // 如果 Redis 服务设置了密码，需要下面这行，没有就不需要
        // jedis.auth("123456");
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: " + jedis.ping());
        jedis.set("name", "zhangsan");
        System.out.println(jedis.get("name"));
//        Config config = new Config();
//        //单机模式  依次设置redis地址和密码
//        config.useSingleServer().setAddress("127.0.0.1:6379");
//        RedissonClient client = Redisson.create(config);
//
//
//        RLock test = client.getLock("test");
//        while (true){
//            boolean b = test.tryLock();
//            System.out.println(b);
//            Thread.sleep(1000L);
//        }
//        test.lock(30, TimeUnit.SECONDS);
//        Thread.sleep(100000L);
//        test.unlock();
    }
}
