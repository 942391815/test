package com.test.java;

import org.apache.shiro.crypto.hash.Md5Hash;

public class TestMd5 {
	public static void main(String[] args) {
		String source = "11111";
		String salt = "12";
		Md5Hash md5 = new Md5Hash(source, salt, 1);
		System.out.println(md5.toBase64());
	}
}
