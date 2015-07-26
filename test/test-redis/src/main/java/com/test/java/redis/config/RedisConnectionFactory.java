package com.test.java.redis.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import com.test.java.redis.constant.Constant;
import com.test.java.util.string.StringUtils;
/**
 * 
 * @author micheal
 * @date 2015-7-26 下午12:38:20
 * @desTODO 此类用于获取数据库连接
 */
public class RedisConnectionFactory {
	public static ShardedJedis shardedJedis = null;
	static {
		InputStream inputStream = RedisConnectionFactory.class.getClassLoader()
				.getResourceAsStream(Constant.PROPERTIES_NAME);
		
		Properties properties = new Properties();
		try {
			properties.load(inputStream);
			String host = properties.getProperty("host");
			String port = properties.getProperty("port");
			String timeOut = properties.getProperty("timeOut");
			if (!StringUtils.isNotBlank(host, port)) {
				throw new RuntimeException("host or port is null !!!");
			}
			JedisPoolConfig config = new JedisPoolConfig();
			config.setMaxIdle(50);
			config.setMaxTotal(500);
			ShardedJedisPool jedisPool = new ShardedJedisPool(config,
					JedisShardInfoFactory.getSharedJedisInfo(host, port,timeOut));
			shardedJedis = jedisPool.getResource();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static ShardedJedis getShardedJedis(){
		return shardedJedis;
	}
}
