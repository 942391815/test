package com.test.java.book.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public class MultiplexerTimeServer implements Runnable{
	private Selector selector;
	private ServerSocketChannel ssc;
	private volatile boolean stop;
	
	public MultiplexerTimeServer(int port) throws Exception{
		selector = Selector.open();
		ssc = ServerSocketChannel.open();
		ssc.configureBlocking(false);
		ssc.socket().bind(new InetSocketAddress(port),1024);
		
		ssc.register(selector, SelectionKey.OP_ACCEPT);
		System.out.println("The time Server is start in port: "+port);
		
	}
	public void stop(){
		this.stop = true;
	}
	public void run() {
		while(!stop){
			try {
				selector.select(1000);
				Iterator<SelectionKey> it = selector.selectedKeys().iterator();
				while(it.hasNext()){
					SelectionKey key = it.next();
					it.remove();
					handleInput(key);
					if(key!=null){
						key.cancel();
						if(key.channel()!=null){
							key.channel().close();
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
		
	}
	private void handleInput(SelectionKey key) {
		if(key.isValid()){
			try{
			if(key.isAcceptable()){
					ServerSocketChannel ssc = (ServerSocketChannel)key.channel();
					SocketChannel sc = ssc.accept();
					sc.configureBlocking(false);
					sc.register(selector, SelectionKey.OP_READ);
			}
			if(key.isReadable()){
				SocketChannel sc = (SocketChannel)key.channel();
				ByteBuffer allocate = ByteBuffer.allocate(1024);
				int readBytes = sc.read(allocate);
				if(readBytes>0){
					allocate.flip();
					byte[] bytes = new byte[allocate.remaining()];
					allocate.get(bytes);
					String body = new String(bytes,"UTF-8");
					
					System.out.println("the server body : "+body);
					
					doWrite(sc,new Date().toString());
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		}
	}
	private void doWrite(SocketChannel channel,String response) throws Exception{
		byte[] bytes = response.getBytes();
		ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
		writeBuffer.put(bytes);
		writeBuffer.flip();
		channel.write(writeBuffer);
	}
}