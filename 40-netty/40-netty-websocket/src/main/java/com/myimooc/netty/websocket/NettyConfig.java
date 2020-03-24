package com.myimooc.netty.websocket;

import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * Netty 全局配置类；存储整个工程的全局配置
 *
 * @author zc 2018-04-11
 */
public class NettyConfig {

    /**
     * 存储每一个客户端接入进来时的 Channel
     */
    public static ChannelGroup group = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

}
