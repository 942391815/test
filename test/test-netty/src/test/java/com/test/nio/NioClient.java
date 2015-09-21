package com.test.nio;

import java.io.ByteArrayOutputStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NioClient {
	static ByteBuffer readBuffer = ByteBuffer.allocate(1024);
	static ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
	public static void main(String[] args) throws Exception{
		SocketChannel client = SocketChannel.open();
		InetSocketAddress address = new InetSocketAddress(8080);
		Selector selector = Selector.open();
		client.configureBlocking(false);
		client.connect(address);
		client.register(selector, SelectionKey.OP_CONNECT);
		
		while(true){
			if(selector.select()>0){
				Set<SelectionKey> set = selector.selectedKeys();
				Iterator<SelectionKey> keys = set.iterator();
				while(keys.hasNext()){
					SelectionKey key = keys.next();
					keys.remove();
					client = (SocketChannel)key.channel();
					if(key.isConnectable()){
//						System.out.println("client connect ...");
						client.register(selector, SelectionKey.OP_READ);
						client.finishConnect();
//					if(client.isConnectionPending()){//是否已经连接完成
//						writeBuffer.clear();
//						writeBuffer.put("hello server ".getBytes());
//						writeBuffer.flip();
//						client.write(writeBuffer);
//					}
					}else if(key.isReadable()){
						key.attach(new Integer(1));
						ByteArrayOutputStream output=new ByteArrayOutputStream();
						ByteBuffer buffer=ByteBuffer.allocate(1024);
						int len=0;
						while((len=client.read(buffer))!=0){
							buffer.flip();
							byte by[]=new byte[buffer.remaining()];
							buffer.get(by);
							output.write(by);
							buffer.clear();
						}
						System.out.println(new String(output.toByteArray()));
						output.close();
//						readBuffer.clear();
//						int count = client.read(readBuffer);
//						if(count >0){
//							System.out.println(new String(readBuffer.array()));
//						}
//						client.register(selector, SelectionKey.OP_WRITE);
					}else if(key.isWritable()){
//						writeBuffer.clear();
//						writeBuffer.put("send to server ".getBytes());
//						writeBuffer.flip();
						client.write(ByteBuffer.wrap("send to server ".getBytes()));
						System.out.println("发送数据完成。。。。");
//						client.register(selector, SelectionKey.OP_READ);
					}
				}
			}
		}
	}
//	public static void handleData(SelectionKey key) throws Exception{
//		
//		
//	}
}
