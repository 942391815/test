//package com.test.java;
//
//import io.netty.bootstrap.ServerBootstrap;
//import io.netty.buffer.ByteBuf;
//import io.netty.buffer.Unpooled;
//import io.netty.channel.ChannelFuture;
//import io.netty.channel.ChannelHandlerAdapter;
//import io.netty.channel.ChannelHandlerContext;
//import io.netty.channel.ChannelInitializer;
//import io.netty.channel.ChannelOption;
//import io.netty.channel.EventLoopGroup;
//import io.netty.channel.nio.NioEventLoopGroup;
//import io.netty.channel.socket.SocketChannel;
//import io.netty.channel.socket.nio.NioServerSocketChannel;
//
//import java.util.Date;
//
///**
// * Netty4 ����˴���
// *
// * @author lihzh
// * @date 2013��11��15�� ����1:10:06
// * @website http://www.coderli.com
// */
//public class HelloWorldServer {
//      public static void main(String[] args) {
//           // EventLoop ����ԭ���� ChannelFactory
//          EventLoopGroup bossGroup = new NioEventLoopGroup();
//          EventLoopGroup workerGroup = new NioEventLoopGroup();
//           try {
//               ServerBootstrap serverBootstrap = new ServerBootstrap();
//               // server�˲��ü�����д��ʽ��client�˲��÷ֶ���ͨд����
//              serverBootstrap.group(bossGroup, workerGroup)
//                        .channel(NioServerSocketChannel.class)
//                        .childHandler( new ChannelInitializer<SocketChannel>() {
//                              @Override
//                              public void initChannel(SocketChannel ch)
//                                       throws Exception {
//                                  ch.pipeline().addLast( new HelloServerHandler());
//                             }
//                        }).option(ChannelOption.SO_BACKLOG,1024);
//
//              ChannelFuture f = serverBootstrap.bind(8000).sync();
//              f.channel().closeFuture().sync();
//          } catch (InterruptedException e) {
//          } finally {
//              workerGroup.shutdownGracefully();
//              bossGroup.shutdownGracefully();
//          }
//     }
//
//      private static class HelloServerHandler extends
//      ChannelHandlerAdapter {
//		@Override
//		public void channelRead(ChannelHandlerContext ctx, Object msg)
//				throws Exception {
//			@SuppressWarnings("deprecation")
//			ByteBuf resp = Unpooled.copiedBuffer(new Date().toLocaleString().getBytes());
//			ctx.write(resp);
//		}
//		public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
//			ctx.flush();
//		}
//     }
//
//}