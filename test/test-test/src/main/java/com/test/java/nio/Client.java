package com.test.java.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class Client {
	public int size = 1024;
	public ByteBuffer inbuffer = ByteBuffer.allocate(size);
	public ByteBuffer outbuffer = ByteBuffer.allocate(size);
	Selector selector = Selector.open();
	SocketChannel clientChannel = SocketChannel.open();
	public Client() throws Exception{
		clientChannel.configureBlocking(false);
		clientChannel.connect(new InetSocketAddress("localhost", 8000));
		clientChannel.register(selector, SelectionKey.OP_CONNECT);
	}
	public void listen() throws Exception{
		int i=0;
		while(true){
			selector.select();
			Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
			while(iterator.hasNext()){
				SelectionKey key = iterator.next();
				iterator.remove();
				if(key.isConnectable()){
					clientChannel.finishConnect();
					clientChannel.register(selector, SelectionKey.OP_WRITE);
					break;
				}else if(key.isReadable()){
					int read = clientChannel.read(inbuffer);
					if(read>0){
						System.out.println("client message read...."+new String(inbuffer.array(),0,read));
						clientChannel.register(selector, SelectionKey.OP_WRITE);
					}
				}else if(key.isWritable()){
					String messageOut = "client message out... "+(i++);
					ByteBuffer writeBuffer = ByteBuffer.wrap(messageOut.getBytes());
					writeBuffer.flip();
					clientChannel.write(inbuffer);
				}
			}
		}
	}
	public static void main(String[] args) throws Exception{
		new Client().listen();
	}
}
