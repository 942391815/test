package com.test.java.thread;

public class Thread1 implements Runnable{
	@Override
	public void run() {
		try {
			Thread.sleep(5000);
			System.out.println(1212);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
