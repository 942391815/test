package com.test.java;

import java.util.List;

public class Test {
	public static void main(String[] args) throws Exception {
		String address = "192.168.100.104:2181";
		ClientApi ca = new ClientApi(address);
		ca.intransation();
		
		
	}
}
