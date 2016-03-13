//package com.test.java.distributelock;
//
//import org.apache.curator.framework.CuratorFramework;
//import org.apache.curator.framework.CuratorFrameworkFactory;
//import org.apache.curator.framework.recipes.cache.NodeCacheListener;
//import org.apache.curator.framework.recipes.cache.PathChildrenCache;
//import org.apache.curator.retry.RetryNTimes;
//import org.apache.zookeeper.CreateMode;
//import org.apache.zookeeper.WatchedEvent;
//import org.apache.zookeeper.Watcher;
//
//
//public class Test{
//	public static void main(String[] args) throws Exception {
//		Test test = new Test();
//		CuratorFramework client =CuratorFrameworkFactory.builder().connectString("127.0.0.1:2181")
//				.connectionTimeoutMs(3000)
//				.retryPolicy(new RetryNTimes(Integer.MAX_VALUE, 2000)).build();
//		client.start();
//		client.getChildren().usingWatcher(test);
//		client.create().withMode(CreateMode.EPHEMERAL_SEQUENTIAL).forPath("/lock");
////		PathChildrenCache watch = new PathChildrenCache(client, "/lock", false);\
////		watch.getListenable().addListener
//	}
//}
