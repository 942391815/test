package com.test.java.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ListQueue {
	public static int size = 10;
	private ReentrantLock lock = new ReentrantLock();
	private Condition take = lock.newCondition();
	private Condition put = lock.newCondition();
	private List list = new ArrayList();
	public void put(String obj)throws InterruptedException{
		lock.lockInterruptibly();
		try{
			while(list.size()==size){
				System.out.println("队列已经满了。。。");
				put.await();
			}
			System.out.println("put.."+obj);
			list.add(obj);
			take.signalAll();
		}finally{
			lock.unlock();
		}
	}
	public void remove() throws InterruptedException{
		lock.lockInterruptibly();
		try{
			while(list.size()==0){
				System.out.println("队列为空。。。");
				take.await();
			}
			put.signal();
			System.out.println("take..."+list.remove(0));
		}finally{
			lock.unlock();
		}
	}
}
