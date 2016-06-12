package com.test.java.distributionlock;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import com.test.java.redis.config.RedisConnectionFactory;

public class Test {
	public static void main(String[] args) {
		ShardedJedisPool shardedJedisPool = RedisConnectionFactory.getShardedJedisPool();
		for(int i=0;i<200;i++){
			Lock lock = new Lock();
			ShardedJedis resource = shardedJedisPool.getResource();
			new Thread(new DistributionLock(lock, resource)).start(); 
			System.out.println(i);
		}
	}
}
