package com.test.java.thread;

/**
 * ≤…”√condition≤‚ ‘
 * @author Micheal
 *
 */
public class TestBlockQue2 {
	public static void main(String[] args) {
		ListQueue queue = new ListQueue();
		new Thread(new Put2(queue)).start();
		new Thread(new Take2(queue)).start();
	}
}

class Put2 implements Runnable {
	public ListQueue queue;
	public Put2(ListQueue queue) {
		this.queue = queue;
	}
	@Override
	public void run() {
		int i=0;
		while (true) {
			i++;
			try {
				queue.put(i+"");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
class Take2 implements Runnable {
	public ListQueue queue;
	public Take2(ListQueue queue) {
		this.queue = queue;
	}
	@Override
	public void run() {
		while (true) {
			try {
				queue.remove();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}