package com.test.java.book.nio;

public class TimeServer {
	public static int port = 8080;
	public static void main(String[] args) throws Exception {
		MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);
		
		new Thread(timeServer, "NOo tart").start();
	}
}
