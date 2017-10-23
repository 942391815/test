package com.test.java.distributionlock;

import com.test.java.redis.config.RedisConnectionFactory;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class Test {
	public static void main(String[] args) {
		ShardedJedisPool shardedJedisPool = RedisConnectionFactory.getShardedJedisPool();
	}
}
