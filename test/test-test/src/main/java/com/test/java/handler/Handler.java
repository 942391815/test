package com.test.java.handler;

public abstract class Handler {
	protected Handler next;

	public void setNext(Handler next) {
		this.next = next;
	}
	public abstract void doHandler(float discount);
	
	public static Handler getHander(){
		Sailer saler = new Sailer();
		Ceo ceo = new Ceo();
		saler.setNext(ceo);
		return saler;
	}
}
