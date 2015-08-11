package com.test.java.book;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TimeClient {
	public static final int port = 8080;
	public static void main(String[] args) throws Exception{
		Socket socket = new Socket("127.0.0.1",port);
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out = new PrintWriter(socket.getOutputStream());
		out.print("Query time order !!!");
		String resp = in.readLine();
		System.out.println("now is : "+resp);
	}
}
