package com.test.java.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class TimeClient {
	public void connect(int port,String host) throws Exception{
		EventLoopGroup group = new NioEventLoopGroup();
		Bootstrap b = new Bootstrap();
		
		b.group(group).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, true)
		.handler(new ChannelInitializer<Channel>() {
			@Override
			protected void initChannel(Channel ch) throws Exception {
				ch.pipeline().addLast(new TimeClientHandler());
			}
		});
		ChannelFuture f = b.connect(host,port);
		f.channel().closeFuture().sync();
	}
	public static void main(String[] args) throws Exception {
		int port = 8080;
		new TimeClient().connect(port, "127.0.0.1");
	}
}
