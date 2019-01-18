package com.imooc.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * 程序的入口，负责启动应用
 * @author liuyazhuang
 *
 */
public class Main {
	public static void main(String[] args) {
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workGroup);
			b.channel(NioServerSocketChannel.class);
			b.childHandler(new MyWebSocketChannelHandler());
			System.out.println("服务端开启等待客户端连接....");
			Channel ch = b.bind(8888).sync().channel();
			ch.closeFuture().sync();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//优雅的退出程序
			bossGroup.shutdownGracefully();
			workGroup.shutdownGracefully();
		}
	}
}
