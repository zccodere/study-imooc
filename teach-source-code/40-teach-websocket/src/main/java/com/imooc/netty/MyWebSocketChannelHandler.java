package com.imooc.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * 初始化连接时候的各个组件
 * @author liuyazhuang
 *
 */
public class MyWebSocketChannelHandler extends ChannelInitializer<SocketChannel> {

	@Override
	protected void initChannel(SocketChannel e) throws Exception {
		e.pipeline().addLast("http-codec", new HttpServerCodec());
		e.pipeline().addLast("aggregator", new HttpObjectAggregator(65536));
		e.pipeline().addLast("http-chunked", new ChunkedWriteHandler());
		e.pipeline().addLast("handler", new MyWebSocketHandler());
	}

}
