package com.test.java.distributelock;

public class GoodDto {
	/**
	 * 剩余商品的数量
	 */
	private volatile int goodsNumber;
	
	public int incrNumber(){
		return goodsNumber++;
	}
}