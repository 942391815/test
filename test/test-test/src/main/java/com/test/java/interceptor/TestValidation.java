package com.test.java.interceptor;

import org.springframework.stereotype.Service;

@Service
public class TestValidation implements Validation{
	@Override
	public boolean execute(Object ob) {
		System.out.println(1212);
		return false;
	}
}
