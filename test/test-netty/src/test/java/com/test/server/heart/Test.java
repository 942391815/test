package com.test.server.heart;


import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

public class Test {
	public static void main(String[] args) throws Exception{
		
		Bootstrap bootstrap = new Bootstrap();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		bootstrap.group(workerGroup).channel(NioSocketChannel.class);
		ChannelFuture cf = bootstrap.connect(new InetSocketAddress("127.0.0.1", 8000)).sync();
		byte[] req = "QUERY TIME ORDER".getBytes();
		ByteBuf firstMessage = Unpooled.buffer(req.length);
		firstMessage.writeBytes(req);
		cf.channel().writeAndFlush(firstMessage);
	}
}
