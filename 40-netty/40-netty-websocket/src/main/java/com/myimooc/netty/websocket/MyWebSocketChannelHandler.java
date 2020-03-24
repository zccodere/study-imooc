package com.myimooc.netty.websocket;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * 初始化连接时的各个组件
 *
 * @author zc 2018-04-11
 */
public class MyWebSocketChannelHandler extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) {
        // 将请求和应答消息解码为HTTP消息
        ch.pipeline().addLast("http-codec", new HttpServerCodec());
        // 将HTTP消息的多个部分合成一条完整的HTTP消息
        ch.pipeline().addLast("aggregator", new HttpObjectAggregator(65536));
        // 向客户端发送HTML5文件
        ch.pipeline().addLast("http-chunked", new ChunkedWriteHandler());
        ch.pipeline().addLast("handler", new MyWebSocketHandler());
    }
}
