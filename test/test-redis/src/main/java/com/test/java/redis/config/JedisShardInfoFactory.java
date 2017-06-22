package com.test.java.redis.config;

import java.util.ArrayList;
import java.util.List;

import com.test.java.redis.constant.Constant;
import com.test.java.util.string.StringUtils;

import redis.clients.jedis.JedisShardInfo;
/**
 * 用于获取 JedisShardInfo 暂时代码硬编码不支持redis集群设置
 * @author micheal
 *
 */
public abstract class JedisShardInfoFactory {
	public static final int PROT=6379;
	/**
	 * @param host redis连接 主机名
	 * @param port redis连接端口
	 * @param timeOut 连接时间设置
	 * @return
	 */
	public static List<JedisShardInfo> getSharedJedisInfo(String host,String timeOut){
		JedisShardInfo jedisShardInfo = null;
		if(StringUtils.isNotBlank(timeOut)){
			jedisShardInfo = new JedisShardInfo(host, PROT, timeOut);
		}else{
			jedisShardInfo = new JedisShardInfo(host, PROT, Constant.TIME_OUT);
		}
		List<JedisShardInfo> jedisShardList =  new ArrayList<JedisShardInfo>();
		jedisShardList.add(jedisShardInfo);
		return jedisShardList;
	}
}
