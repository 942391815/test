package com.test.java;

import java.net.InetSocketAddress;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;


/**
 * Netty4 �ͻ��˴���
 * @author OneCoder
 * @date 2013��11��15�� ����1:28:21
 * @website http://www.coderli.com
 */
public class HelloWorldClient {
      public static void main(String args[]) throws Exception {
           // Client���������� 3.x��ClientBootstrap ��ΪBootstrap���ҹ��캯���仯�ܴ��������޲ι��졣
          Bootstrap bootstrap = new Bootstrap();
           // ָ��channel����
          bootstrap.channel(NioSocketChannel.class);
           // ָ��Handler
          bootstrap.handler(new ChannelInitializer<SocketChannel>() {
        	  public void initChannel(SocketChannel ch){
        		  ch.pipeline().addLast(new HelloClientHandler());
        	  }
		});
           // ָ��EventLoopGroup
          bootstrap.group( new NioEventLoopGroup());
           // ���ӵ����ص�8000�˿ڵķ����
          ChannelFuture f = bootstrap.connect(new InetSocketAddress("127.0.0.1" , 8000)).sync();
          f.channel().closeFuture().sync();
     }
      private static class HelloClientHandler extends
      ChannelHandlerAdapter {
           /**
           * ���󶨵�����˵�ʱ�򴥷�����ӡ"Hello world, I'm client."
           * @alia OneCoder
           * @author lihzh
           * @date 2013��11��16�� ����12:50:47
           */
    	  
           public void channelActive(ChannelHandlerContext ctx) throws Exception {
        	   System. out .println("Hello world, I'm client.");
        	   ByteBuf firstMessage = null;
        	   byte[] req = "micheal".getBytes();
        		firstMessage = Unpooled.buffer(req.length);
        		firstMessage.writeBytes(req);
        		ctx.writeAndFlush(firstMessage);
          }
   		public void channelRead(ChannelHandlerContext ctx, Object msg)
   				throws Exception {
   			ByteBuf buf = null;
   			if(msg instanceof ByteBuf){
   				buf = (ByteBuf)msg;
   			}
   			if(buf !=null){
   				byte[] req = new byte[buf.readableBytes()];
   				buf.readBytes(req);
   				String body = new String(req,"UTF-8");
   				System.out.println(body);
   			}
   		}
     }
      
}