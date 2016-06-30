package com.test.java.distributionlock;

import redis.clients.jedis.ShardedJedis;

public class Lock {
	public static String LOCK = "LOCK";
	private ShardedJedis shardedJedis;
	public void setJedis(ShardedJedis shardedJedis){
		this.shardedJedis = shardedJedis;
	}
	public boolean tryLock(){
		if(shardedJedis.setnx(LOCK, System.currentTimeMillis()+"")>0){
			return true;
		}
		return false;
	}
	public void releaseLock(){
		shardedJedis.del(LOCK);
	}
}
