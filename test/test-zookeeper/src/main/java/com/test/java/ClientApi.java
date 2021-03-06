package com.test.java;

import java.util.List;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.CuratorWatcher;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.data.Stat;

public class ClientApi{
	private final CuratorFramework client;
	public void intransation() throws Exception{
		
//		 try {
//			 Collection<CuratorTransactionResult> results = client.inTransaction().create().forPath("/a/path", "some data".getBytes())
//			 .and().setData().forPath("/another/path", "other data".getBytes())
//			 .and().delete().forPath("/yet/another/path")
//			 .and().commit();
//			 
//			 
//			 
//			 for (CuratorTransactionResult result : results) {
//		            System.out.println(result.getForPath() + " - " + result.getType());
//		       }
//		} catch (Exception e) {
//			e.printStackTrace();
//		} // IMPORTANT!
////		client.inTransaction();
//	    CuratorTransaction transaction = client.inTransaction();  
//	    transaction.create();
//	    
//	    Collection<CuratorTransactionResult> results = transaction.create()  
//                .forPath("/abc", "other data".getBytes())
//                .and().delete().forPath("/app")  
//                .and().commit();  
//        for (CuratorTransactionResult result : results) {  
//            System.out.println(result.getForPath() + " - " + result.getType());  
//        } 
		
	}
	/**
	 * 节点添加锁
	 * @param path
	 * @throws Exception
     */
	public void nodeAddLock(String path) throws Exception{
		InterProcessMutex lock = new InterProcessMutex(client, path);
		try {
			lock.acquire();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			lock.release();
		}
	}
	public ClientApi(String conn) {
		client = CuratorFrameworkFactory.builder().connectString(conn)
				.connectionTimeoutMs(3000)
				.retryPolicy(new RetryNTimes(Integer.MAX_VALUE, 2000)).build();
		client.start();
	}
	public List<String> watchNode(String path){
		try{
			List<String> result = client.getChildren().usingWatcher(new CuratorWatcher() {
				@Override
				public void process(WatchedEvent event) throws Exception {
					System.out.println(event.getType());	
				}
			}).forPath(path);
			return result;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 判断节点是否存在
	 * @param path
	 * @return
     */
	public boolean isExist(String path) {
		try {
			Stat stat = client.checkExists().forPath(path);
			if (stat == null) {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	public byte[] getPathValue(String path) {
		try {
			return client.getData().forPath(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 获取一个节点的子节点
	 * @param path
	 * @return
     */
	public List<String> getChildren(String path) {
		try {
			return client.getChildren().forPath(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 删除某个节点
	 * @param path
     */
	public void deleteNode(String path) {
		try {
			client.delete().forPath(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 创建节点
	 * @param path
	 * @param value
     */
	public void createNode(String path, byte[] value) {
		try {
			client.create().creatingParentsIfNeeded()
					.withMode(CreateMode.PERSISTENT).forPath(path, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 更新节点
	 * @param path
	 * @param value
	 */
	public void updateNode(String path, byte[] value) {
		try {
			Stat stat = client.checkExists().forPath(path);
			if (stat != null) {
				client.setData().forPath(path, value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
