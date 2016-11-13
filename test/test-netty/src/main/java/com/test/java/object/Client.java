//package com.test.java.object;
//
//
//import io.netty.bootstrap.Bootstrap;
//import io.netty.buffer.ByteBuf;
//import io.netty.channel.ChannelFuture;
//import io.netty.channel.ChannelHandler.Skip;
//import io.netty.channel.ChannelHandlerAdapter;
//import io.netty.channel.ChannelHandlerContext;
//import io.netty.channel.ChannelInitializer;
//import io.netty.channel.ChannelOption;
//import io.netty.channel.nio.NioEventLoopGroup;
//import io.netty.channel.socket.SocketChannel;
//import io.netty.channel.socket.nio.NioSocketChannel;
//import io.netty.handler.codec.serialization.ClassResolvers;
//import io.netty.handler.codec.serialization.ObjectDecoder;
//import io.netty.handler.codec.serialization.ObjectEncoder;
//
//public class Client {
//	public static void main(String[] args) {
//		NioEventLoopGroup eventGroup = new NioEventLoopGroup();
//		try {
//		Bootstrap b = new Bootstrap();
//		b.group(eventGroup).channel(NioSocketChannel.class)
//		.option(ChannelOption.TCP_NODELAY, true)
//		.handler(new ChannelInitializer<SocketChannel>() {
//			@Override
//			protected void initChannel(SocketChannel ch) throws Exception {
//				ch.pipeline().addLast(MarshallingCodeCFactory.buildMarshallingEncoder(),
//						MarshallingCodeCFactory.buildMarshallingDecoder(),new ClientHandler());
//
////				ch.pipeline().addLast(
////						new ObjectEncoder(),
////                        new ObjectDecoder(ClassResolvers.cacheDisabled(null)),
////                        new ClientHandler()
////						);
//
//			}
//		});
//		ChannelFuture result = b.connect("192.168.100.104", 8000).sync();
//		result.channel().closeFuture().sync();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}finally{
//			eventGroup.shutdownGracefully();
//		}
//	}
//}
//class ClientHandler extends ChannelHandlerAdapter{
//	@Override
//	public void channelActive(ChannelHandlerContext ctx) throws Exception {
//		System.out.println("this is client");
//		Person person = new Person("zhangsan","32");
//		ctx.writeAndFlush(person);
//	}
//
//	@Override
//	public void channelRead(ChannelHandlerContext ctx, Object msg)
//			throws Exception {
//		Person p = (Person)msg;
//		System.out.println(p.getAge()+"------"+p.getName());
//	}
//
//	@Override
//	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
//		ctx.flush();
//	}
//
//}
//
