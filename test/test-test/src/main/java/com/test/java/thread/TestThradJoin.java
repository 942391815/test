package com.test.java.thread;

public class TestThradJoin {
	public static void main(String[] args) throws InterruptedException {
		 System.out.println(System.getProperty("java.ext.dirs"));
		   ClassLoader extensionClassloader=ClassLoader.getSystemClassLoader().getParent();
		   System.out.println("the parent of extension classloader : "+extensionClassloader.getParent());
		   System.out.println(System.getProperty("java.class.path"));
	}
}
