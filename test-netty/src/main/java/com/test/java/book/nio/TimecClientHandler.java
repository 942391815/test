package com.test.java.book.nio;

import java.io.IOException;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public class TimecClientHandler implements Runnable{
	private String host;
	private int port;
	private Selector selector;
	private SocketChannel socketChannel;
	
	public TimecClientHandler(String host,int port){
		this.host = host;
		this.port = port;
		try {
			selector = Selector.open();
			SocketChannel socketChannel = SocketChannel.open();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void run() {
		
	}
}
