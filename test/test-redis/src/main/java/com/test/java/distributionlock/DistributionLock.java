package com.test.java.distributionlock;

import redis.clients.jedis.ShardedJedis;

public class DistributionLock implements Runnable{
	private Lock lock;
	private ShardedJedis resource;
	public DistributionLock(Lock lock,ShardedJedis resource){
		this.lock = lock;
		this.resource = resource;
	}
	public void run() {
		lock.setJedis(resource);
		while(true){
			if(lock.tryLock()){
				String count = resource.get("count");
				resource.set("count", (Integer.parseInt(count)+1)+"");
				lock.releaseLock();
				break;
			}
		}
	}
}
