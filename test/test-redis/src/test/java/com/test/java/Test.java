package com.test.java;

import redis.clients.jedis.ShardedJedis;

import com.test.java.redis.config.RedisConnectionFactory;


public class Test {
	public static void main(String[] args) {
		ShardedJedis pool = RedisConnectionFactory.getShardedJedis();
		pool.set("name", "zhangsan");
	}
}
