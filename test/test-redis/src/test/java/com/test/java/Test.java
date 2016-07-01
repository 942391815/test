package com.test.java;

import com.test.java.redis.config.RedisConnectionFactory;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;



public class Test {
	public static void main(String[] args) {
//		ShardedJedisPool pool = RedisConnectionFactory.getShardedJedisPool();
//		ShardedJedis resource = pool.getResource();
//		resource.set("name", "zhangsan");
//		pool.returnResource(resource);
	}
}
