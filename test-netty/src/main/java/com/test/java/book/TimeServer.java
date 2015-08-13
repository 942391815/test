package com.test.java.book;

import java.net.ServerSocket;
import java.net.Socket;

public class TimeServer {
	public static void main(String[] args) throws Exception{
		int port =8080;
		ServerSocket server = null;
		server = new ServerSocket(port);
		System.out.println("start !...");
		
		Socket socket = null;
		
		while(true){
			socket = server.accept();
			new Thread(new TimeServerHandler(socket)).start();
		}
	}
}
