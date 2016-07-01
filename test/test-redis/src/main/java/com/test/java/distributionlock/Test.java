package com.test.java.distributionlock;

import com.test.java.redis.config.RedisConnectionFactory;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class Test {
	public static void main(String[] args) {
		ShardedJedisPool shardedJedisPool = RedisConnectionFactory.getShardedJedisPool();
//		for(int i=0;i<200;i++){
			Lock lock = new Lock();
			ShardedJedis resource = shardedJedisPool.getResource();
			resource.set("name1", "zhangsan");
//			new Thread(new DistributionLock(lock, resource)).start(); 
//			System.out.println(i);
//		}
	}
}
