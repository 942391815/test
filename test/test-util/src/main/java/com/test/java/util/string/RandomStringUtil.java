package com.test.java.util.string;

import java.util.UUID;

/**
 * 随机获取字符串
 * @author micheal
 *
 */
public class RandomStringUtil {
	/**
	 * get UUID
	 * @return
	 */
	public static String getRandomString(){
		return UUID.randomUUID().toString().replace("-","");
	}
	public static void main(String[] args) {
		System.out.println(getRandomString());
	}
}
