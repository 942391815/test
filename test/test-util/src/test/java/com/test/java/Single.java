package com.test.java;

/**
 * 通过内部类实现单例的延迟加载。同时线程安全。
 * @author micheal
 *
 */
public class Single {
	private Single(){}
	public static Single getInstance() {
		return SingleUtils.single;
	}
	public static class SingleUtils {
		private static Single single = new Single();
	}
}
