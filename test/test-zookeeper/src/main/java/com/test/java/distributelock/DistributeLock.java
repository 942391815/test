package com.test.java.distributelock;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMultiLock;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.RetryNTimes;


/**
 * 测试zookeeper的分布式锁
 * 开启四个线程对同一个数字进行操作
 * @author micheal
 *
 */
public class DistributeLock implements Runnable{
	/** Zookeeper info */
	private static final String ZK_ADDRESS = "127.0.0.1:2181";

	public static void main(String[] args) throws Exception {
		for(int i=0;i<10;i++){
			Thread tt = new Thread(new DistributeLock());
			tt.start();
		}
	}

	@Override
	public void run() {
		// 1.Connect to zk
		CuratorFramework client = CuratorFrameworkFactory.newClient(ZK_ADDRESS,
				new RetryNTimes(10, 5000));
		client.start();
		InterProcessMutex lock = new InterProcessMutex(client, "/lock");
		try {
			lock.acquire();
			byte[] forPath = client.getData().forPath("/lock");
			if(forPath==null||forPath.length==0){
				String data = "0";
				client.setData().forPath("/lock", data.getBytes());
			}else{
				int i = Integer.parseInt(new String(forPath));
				int data = i+1;
				String result = data+"";
				client.setData().forPath("/lock",result.getBytes());
				System.out.println(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				lock.release();
				client.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
