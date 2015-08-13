package com.test.java.book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TimeServerHandler implements Runnable{
	private Socket socket;
	public TimeServerHandler(Socket socket){
		this.socket = socket;
	}
	public void run(){
		BufferedReader in = null;
		PrintWriter out = null;
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		String currentTime = null;
		String body = null;
		while(true){
			try {
				body = in.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(body == null){
				break;
			}
			System.out.println("The time server receive order : "+body);
		}
	}

}
