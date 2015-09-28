package com.test.java.handler;

public class Ceo extends Handler{

	@Override
	public void doHandler(float discount) {
		if(discount>0.8){
			System.out.println("I can not do");
		}else{
			System.out.println(" I promise");
		}
	}

}
