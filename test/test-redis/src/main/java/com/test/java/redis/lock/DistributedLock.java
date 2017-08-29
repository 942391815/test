//package com.test.java.redis.lock;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import redis.clients.jedis.ShardedJedis;
//import redis.clients.jedis.ShardedJedisPool;
//
//@Service
//public class DistributedLock {
//	@Autowired
//	private ShardedJedisPool shardedJedisPool;
//
//	public boolean acquireLock(String lock,long expired) {
//	    // 1. 通过SETNX试图获取一个lock
//	    boolean success = false;
//	    ShardedJedis jedis = shardedJedisPool.getResource();
//	    long value = System.currentTimeMillis() + expired + 1;
//	    System.out.println(value);
//	    long acquired = jedis.setnx(lock, String.valueOf(value));
//	    //SETNX成功，则成功获取一个锁
//	    if (acquired == 1)
//	        success = true;
//	    //SETNX失败，说明锁仍然被其他对象保持，检查其是否已经超时
//	    else {
//	        long oldValue = Long.valueOf(jedis.get(lock));
//
//	        //超时
//	        if (oldValue < System.currentTimeMillis()) {
//	            String getValue = jedis.getSet(lock, String.valueOf(value));
//	            // 获取锁成功
//	            if (Long.valueOf(getValue) == oldValue)
//	                success = true;
//	            // 已被其他进程捷足先登了
//	            else
//	                success = false;
//	        }
//	        //未超时，则直接返回失败
//	        else
//	            success = false;
//	    }
//	    shardedJedisPool.returnResource(jedis);
//	    return success;
//	}
//
//	//释放锁
//	public void releaseLock(String lock) {
//		ShardedJedis jedis = shardedJedisPool.getResource();
//	    long current = System.currentTimeMillis();
//	    // 避免删除非自己获取得到的锁
//	    if (current < Long.valueOf(jedis.get(lock)))
//	        jedis.del(lock);
//	    shardedJedisPool.returnResource(jedis);
//	}
//
//}
