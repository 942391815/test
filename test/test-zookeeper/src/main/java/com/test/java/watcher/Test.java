package com.test.java.watcher;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

public class Test implements Watcher{
	private static CountDownLatch countDown = new CountDownLatch(1);
	private static ZooKeeper zk = null;
	public static void main(String[] args) throws Exception {
		String path = "/zk-book";
		zk = new ZooKeeper("127.0.0.1:2181", 5000,new Test());
		countDown.await();
		zk.create(path, "".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		zk.create(path+"/c1", "".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
		
		List<String> childrenList = zk.getChildren(path, true);
		System.out.println(childrenList);
		
		zk.create(path+"/c2", "".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
		Thread.sleep(Integer.MAX_VALUE);
	}
	@Override
	public void process(WatchedEvent event) {
		if(KeeperState.SyncConnected==event.getState()){
			if(EventType.None==event.getType()&&null==event.getPath()){
				countDown.countDown();
			}else if(EventType.NodeChildrenChanged==event.getType()){
				try {
					System.out.println(zk.getChildren(event.getPath(), true));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
