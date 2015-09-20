package com.test.nio;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NioClient {
	Selector selector = null;
	static ByteBuffer readBuffer = ByteBuffer.allocate(1024);
	static ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
	public static void main(String[] args) throws Exception{
		SocketChannel client = SocketChannel.open();
		InetSocketAddress address = new InetSocketAddress("127.0.0.1",8000);
		Selector selector = Selector.open();
		client.configureBlocking(false);
		client.connect(address);
		client.register(selector, SelectionKey.OP_CONNECT);
//		String receiveText = null;
//		String sendText = null;
		while(true){
			Set<SelectionKey> set = selector.keys();
			Iterator<SelectionKey> keys = set.iterator();
			while(keys.hasNext()){
				SelectionKey key = keys.next();
				keys.remove();
				if(key.isConnectable()){
					System.out.println("client connect ...");
					client = (SocketChannel)key.channel();
					if(client.isConnectionPending()){//是否已经连接完成
						writeBuffer.clear();
						writeBuffer.put("hello server ".getBytes());
						writeBuffer.flip();
						client.write(writeBuffer);
					}
					client.register(selector, SelectionKey.OP_READ);
				}else if(key.isReadable()){
					client = (SocketChannel)key.channel();
					readBuffer.clear();
					int count = client.read(readBuffer);
					if(count >0){
						System.out.println(new String(readBuffer.array()));
					}
					client.register(selector, SelectionKey.OP_WRITE);
				}else if(key.isWritable()){
					writeBuffer.clear();
					client = (SocketChannel)key.channel();
					writeBuffer.put("send to server ".getBytes());
					writeBuffer.flip();
					client.write(writeBuffer);
					System.out.println("发送数据完成。。。。");
					client.register(selector, SelectionKey.OP_READ);
				}
//				iterator.remove();
			}
//			set.clear();
		}
	}
	public static void handleData(SelectionKey key) throws Exception{
		
		
	}
}
