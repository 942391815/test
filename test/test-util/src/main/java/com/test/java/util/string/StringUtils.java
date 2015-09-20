package com.test.java.util.string;
/**
 * 字符串工具类
 * @author micheal
 *
 */
public class StringUtils {
	/**
	 * 判断字符串时候为空
	 * @param target 目标字符串
	 * @return true or false
	 */
	public static boolean  isNotBlank(String target){
		if(target==null||"".equals(target.trim())){
			return false;
		}
		return true;
	}
	/**
	 * 判断字符串时候为空 所有的字符串参数都不能为空
	 * @param target 目标参数
	 * @return boolean
	 */
	public static boolean isNotBlank(String  ...target){
		for(int i=0;i<target.length;i++){
			if(target[i]==null||"".equals(target[i].trim())){
				return false;
			}
		}
		return true;
	}
}
