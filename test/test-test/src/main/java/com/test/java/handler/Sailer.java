package com.test.java.handler;

public class Sailer extends Handler{

	@Override
	public void doHandler(float discount) {
		if(discount > 0.5){
			this.next.doHandler(discount);
		}else{
			System.out.println("sailer do");
		}
	}

}
