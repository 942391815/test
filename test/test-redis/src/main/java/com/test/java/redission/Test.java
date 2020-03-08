package com.test.java.redission;

import org.redisson.Config;
import org.redisson.Redisson;
import org.redisson.RedissonClient;
import org.redisson.core.RLock;

/**
 * Created by Micheal on 2020/3/6.
 */
public class Test {
    public static void main(String[] args) {
        Config config = null;
        RedissonClient client = Redisson.create(config);
        RLock lock = client.getLock("");
        lock.lock();
        lock.lock();
        lock.unlock();
    }
}
