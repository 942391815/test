package com.test.nio;


import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;



public class NioServer {
	Selector selector = null;
	ByteBuffer readBuffer = ByteBuffer.allocate(1024);
	ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
	public static void main(String[] args) throws Exception{
		NioServer server = new NioServer();
		server.start(8000);
		server.listen();
	}
	public void start(int port) throws Exception{
		ServerSocketChannel socketChnanel = ServerSocketChannel.open();
		socketChnanel.configureBlocking(false);
		selector = Selector.open();
		ServerSocket serverSocket = socketChnanel.socket();
		serverSocket.bind(new InetSocketAddress(port));
		socketChnanel.register(selector, SelectionKey.OP_ACCEPT);
		System.out.println("start");
	}
	public void listen() throws Exception{
		while(true){
			Iterator<SelectionKey> keys = selector.selectedKeys().iterator();
			while(keys.hasNext()){
				SelectionKey key = keys.next();
				handlerKeys(key);
				keys.remove();
//				iterator.remove();
				
			}
		}
	}
	public void handlerKeys(SelectionKey key) throws Exception{
		ServerSocketChannel server = null;
		SocketChannel client = null;
		int count = 0;
		String sendText = null;
		String receiveText = null;
		
		if(key.isAcceptable()){//客户端连接到服务端
			server = (ServerSocketChannel)key.channel();
			client = server.accept();
			client.configureBlocking(false);
			client.register(selector, SelectionKey.OP_READ);
		}else if(key.isReadable()){//接受客户端发送的数据
			client = (SocketChannel)key.channel();
			count = client.read(readBuffer);
			if(count>0){
				System.out.println(new String(readBuffer.array()));
			}
			client.register(selector, SelectionKey.OP_WRITE);
		}else if(key.isWritable()){
			writeBuffer.clear();
			client = (SocketChannel)key.channel();
			String content = "hello word";
			writeBuffer.put(content.getBytes());
			client.write(writeBuffer);
		}
	}
}
