//package com.test.java.object;
//
//import io.netty.bootstrap.ServerBootstrap;
//import io.netty.channel.ChannelFuture;
//import io.netty.channel.ChannelHandlerAdapter;
//import io.netty.channel.ChannelHandlerContext;
//import io.netty.channel.ChannelInitializer;
//import io.netty.channel.ChannelOption;
//import io.netty.channel.EventLoopGroup;
//import io.netty.channel.nio.NioEventLoopGroup;
//import io.netty.channel.socket.SocketChannel;
//import io.netty.channel.socket.nio.NioServerSocketChannel;
//import io.netty.handler.codec.marshalling.MarshallingDecoder;
//import io.netty.handler.codec.serialization.ClassResolvers;
//import io.netty.handler.codec.serialization.ObjectDecoder;
//import io.netty.handler.codec.serialization.ObjectEncoder;
//
//public class Server {
//	public static void main(String[] args) {
//		ServerBootstrap sb = new ServerBootstrap();
//		EventLoopGroup ev1 = new NioEventLoopGroup();
//		EventLoopGroup ev2 = new NioEventLoopGroup();
//		sb.group(ev1, ev2).channel(NioServerSocketChannel.class)
//				.option(ChannelOption.SO_BACKLOG, 1024)
//				.childHandler(new ServerChannelInterlize());
//		try {
//			ChannelFuture f = sb.bind(8000).sync();
//			f.channel().closeFuture().sync();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			ev1.shutdownGracefully();
//			ev2.shutdownGracefully();
//		}
//	}
//}
//
//class ServerChannelInterlize extends ChannelInitializer<SocketChannel> {
//	protected void initChannel(SocketChannel ch) throws Exception {
//		ch.pipeline().addLast(MarshallingCodeCFactory.buildMarshallingEncoder(),
//				MarshallingCodeCFactory.buildMarshallingDecoder(),new ServerHandler());
////		ch.pipeline().addLast(
////				new ObjectEncoder(),
////                new ObjectDecoder(ClassResolvers.cacheDisabled(null)),
////				new ServerHandler()
////				);
//	}
//}
//
//class ServerHandler extends ChannelHandlerAdapter {
//
//	@Override
//	public void channelRead(ChannelHandlerContext ctx, Object msg)
//			throws Exception {
//		Person p = (Person) msg;
//		p.setAge("asdfadsf");
//		ctx.write(p);
//	}
//
//	@Override
//	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
//		ctx.flush();
//	}
//
//	@Override
//	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
//			throws Exception {
//		System.out.println(cause.getMessage());
//	}
//}