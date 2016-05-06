package com.test.java.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class Client {
	public int size = 4096;
	public ByteBuffer inbuffer = ByteBuffer.allocate(size);
	public ByteBuffer outbuffer = ByteBuffer.allocate(size);
	Selector selector = Selector.open();
	SocketChannel clientChannel = SocketChannel.open();
	SocketChannel client = null;
	public Client() throws Exception{
		clientChannel.configureBlocking(false);
		clientChannel.connect(new InetSocketAddress("localhost", 8000));
		clientChannel.register(selector, SelectionKey.OP_CONNECT);
	}
	public void listen() throws Exception{
		while(true){
			int i=0;
			selector.select();
			Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
			while(iterator.hasNext()){
				SelectionKey key = iterator.next();
				iterator.remove();
				if(key.isConnectable()){
					client = (SocketChannel) key.channel();
					if (client.isConnectionPending()) {
                        client.finishConnect();
                        System.out.println("完成连接!");
                        outbuffer.clear();
                        outbuffer.put("Hello,Server".getBytes());
                        outbuffer.flip();
                        client.write(outbuffer);
                    }
					 client.register(selector, SelectionKey.OP_READ);
				}else if(key.isReadable()){
					client = (SocketChannel) key.channel();
					inbuffer.clear();
					int read = client.read(inbuffer);
					if(read>0){
						System.out.println("client receive...."+new String(inbuffer.array(),0,read));
						client.register(selector, SelectionKey.OP_WRITE);
					}
				}else if(key.isWritable()){
					client = (SocketChannel) key.channel();
					outbuffer.clear();
					String messageOut = "client message out... "+(i++);
					outbuffer.put(messageOut.getBytes());
					outbuffer.flip();
					client.write(outbuffer);
					client.register(selector, SelectionKey.OP_READ);
				}
			}
		}
	}
	public static void main(String[] args) throws Exception{
		new Client().listen();
	}
}
