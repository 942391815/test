package com.test.java.redis.service;

/**
 * redis 通用操作类
 * @author micheal
 * @date 2015-7-27 下午9:53:17
 * @desTODO
 */
public interface GeneralHandleService {
	/**
	 *  判断一个对象是否存在
	 * @param key
	 * @return
	 */
	public boolean isExist(String key);
}
