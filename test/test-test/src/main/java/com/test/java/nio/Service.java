package com.test.java.nio;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class Service {
	public int size = 1024;
	public ByteBuffer inbuffer = ByteBuffer.allocate(size);
	public ByteBuffer outbuffer = ByteBuffer.allocate(size);
	Selector selector = Selector.open();
	public Service(int port) throws Exception{
		ServerSocketChannel channel = ServerSocketChannel.open();
		channel.configureBlocking(false);
		ServerSocket serverSocket = channel.socket();
		serverSocket.bind(new InetSocketAddress(port));
		channel.register(selector, SelectionKey.OP_ACCEPT);
		System.out.println("start listener on port "+port +"......");
	}
	public void listen() throws Exception{
		while(true){
			int i=0;
			selector.select();
			Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();
			while(keyIterator.hasNext()){
				SelectionKey key = keyIterator.next();
				keyIterator.remove();
				handlekey(key,i);
			}
		}
		
	}
	public void handlekey(SelectionKey key,int i) throws Exception{
		ServerSocketChannel serverChannel = null;
		SocketChannel clientChannel = null;
		if(key.isAcceptable()){
			serverChannel = (ServerSocketChannel)key.channel();
			clientChannel = serverChannel.accept();
			clientChannel.configureBlocking(false);
			clientChannel.register(selector, SelectionKey.OP_READ);
		}else if(key.isReadable()){
			clientChannel = (SocketChannel)key.channel();
			int read = clientChannel.read(inbuffer);
			if(read>0){
				System.out.println("client message...."+new String(inbuffer.array(),0,inbuffer.position()));
				clientChannel.register(selector, SelectionKey.OP_WRITE);
			}
		}else if(key.isWritable()){
			clientChannel = (SocketChannel)key.channel();
			outbuffer.clear();
			String message = "server message send ..."+(i++);
			outbuffer.put(message.getBytes());
			outbuffer.flip();
			clientChannel.write(outbuffer);
		}
	}
	public static void main(String[] args) throws Exception{
		new Service(8000).listen();
	}
}
