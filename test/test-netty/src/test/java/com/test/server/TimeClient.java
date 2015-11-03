package com.test.server;


import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author lilinfeng
 * @date 2014��2��14��
 * @version 1.0
 */
public class TimeClient {

    public void connect(int port, String host) throws Exception {
	// ���ÿͻ���NIO�߳���
	EventLoopGroup group = new NioEventLoopGroup();
	try {
	    Bootstrap b = new Bootstrap();
	    b.group(group).channel(NioSocketChannel.class)
		    .option(ChannelOption.TCP_NODELAY, true)
		    .handler(new ChannelInitializer<SocketChannel>() {
			@Override
			public void initChannel(SocketChannel ch)
				throws Exception {
			    ch.pipeline().addLast(new TimeClientHandler());
			}
		    });

	    // �����첽���Ӳ���
	    ChannelFuture f = b.connect(host, port).sync();

	    // �����ͻ�����·�ر�
	    f.channel().closeFuture().sync();
	} finally {
	    group.shutdownGracefully();
	}
    }

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
	int port = 8080;
	if (args != null && args.length > 0) {
	    try {
		port = Integer.valueOf(args[0]);
	    } catch (NumberFormatException e) {
		// ����Ĭ��ֵ
	    }
	}
	for(int i=0;i<300;i++){
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					new TimeClient().connect(8080, "127.0.0.1");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
    }
}