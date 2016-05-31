package com.test.java.thread;

import java.util.ArrayList;
import java.util.List;
/**
 * ≤…”√notify ∫Õwait
 * @author Micheal
 *
 */
public class TestBlockQue {
	public List list = new ArrayList();
	public static void main(String[] args) {
		TestBlockQue tt = new TestBlockQue();
		new Thread(new Put(tt.list, 20, Math.random()+"")).start();;
		new Thread(new Take(tt.list, 20)).start();;
	}
}
class Put implements Runnable{
	public List list;
	public int size;
	public String  obj;
	public Put(List list,int size,String obj){
		this.list = list;
		this.size = size;
		this.obj = obj;
	}
	@Override
	public void run() {
		int i=0;
		while(true){
			i++;
			synchronized (list) {
				if(list.size()<size){
					System.out.println("put..."+i);
					list.add(i);
				}else{
					try {
						list.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				list.notify();
			}
		}
	}
}
class Take implements Runnable{
	public List list;
	public int size;
	public Take(List list,int size){
		this.list = list;
		this.size = size;
	}
	@Override
	public void run() {
		while(true){
			synchronized (list) {
				if(list.size()<1){
					try {
						list.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else{
					System.out.println("take..."+list.get(0));
					list.remove(0);
					list.notify();
				}
			}
		}
	}
}