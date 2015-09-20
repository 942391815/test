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
	 * @return 获取随机字符串
	 */
	public static String getRandomString(){
		return UUID.randomUUID().toString().replace("-","");
	}
}
