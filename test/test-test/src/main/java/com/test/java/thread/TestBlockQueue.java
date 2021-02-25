package com.test.java.thread;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
/**
 * jdk
 * @author Micheal
 *
 */
public class TestBlockQueue {
	public static void main(String[] args) {
		ArrayBlockingQueue queue = new ArrayBlockingQueue(10);
		new Thread(new PutQue(queue)).start();
		new Thread(new TakeQue(queue)).start();
	}
}
class PutQue implements Runnable{
	private ArrayBlockingQueue queue;
	public PutQue(ArrayBlockingQueue queue){
		this.queue=queue;
	}
	@Override
	public void run() {
		while(true){
			Double dd = Math.random();
			System.out.println(dd);
			try {
				queue.put(dd);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
class TakeQue implements Runnable{
	private ArrayBlockingQueue queue;
	public TakeQue(ArrayBlockingQueue queue){
		this.queue=queue;
	}
	@Override
	public void run() {
		while(true){
			Object take = null;
			try {
				take = queue.take();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("take..."+take);
		}
	}
}