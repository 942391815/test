package com.test.java.redis.config;

import java.util.ArrayList;
import java.util.List;

import com.test.java.util.string.StringUtils;

import redis.clients.jedis.JedisShardInfo;

public class RedisShardInfo {
	private List<JedisShardInfo> list = null;
	
	public RedisShardInfo(String config){
		if(StringUtils.isNotBlank(config)){
			String[] hostAndPort = config.split(":");
			setJedisShardInfo(hostAndPort);
		}else{
			throw new RuntimeException("redis config must be not null !");
		}
	}
	public List<JedisShardInfo> getList() {
		return list;
	}
	
	private void setJedisShardInfo(String [] hostAndPort){
		if(list == null){
			list = new ArrayList<JedisShardInfo>();
		}
		try{
			if(hostAndPort!=null){
				JedisShardInfo jedisShardInfo = new JedisShardInfo(hostAndPort[0], Integer.parseInt(hostAndPort[1]));
				list.add(jedisShardInfo);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
