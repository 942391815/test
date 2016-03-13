//package com.test.java.distributelock;
//
//import java.util.List;
//
//import org.I0Itec.zkclient.ZkClient;
//public class ZkConnection{
//	private ZkClient client = null;
//	public ZkConnection(String host){
//		client = new ZkClient(host);
//	}
//	/**
//	 * 创建zookeeper临时节点
//	 */
//	public String createEphemeralSquentialNode(String path){
//		return client.createEphemeralSequential(path, null);
//	}
//	public void createPersistNode(String path){
//		client.createPersistent(path);
//	}
//	public boolean isExist(String path){
//		return client.exists(path);
//	}
//	public List<String> getListNode(String path){
//		return client.getChildren(path);
//	}
//	public boolean deleteNode(String path){
//		return client.delete(path);
//	}
//	public void watchNode(String path){
//		client.watchForData(path);
//	}
//}
