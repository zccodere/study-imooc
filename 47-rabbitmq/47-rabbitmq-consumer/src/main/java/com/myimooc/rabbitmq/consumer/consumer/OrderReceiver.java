package com.myimooc.rabbitmq.consumer.consumer;

import com.rabbitmq.client.Channel;
import com.myimooc.rabbitmq.entity.Order;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * <br>
 * 标题: 订单接收者<br>
 * 描述: 订单接收者<br>
 * 时间: 2018/09/06<br>
 *
 * @author zc
 */
@Component
public class OrderReceiver {

    /**
     * 接收消息
     *
     * @param order   消息体内容
     * @param headers 消息头内容
     * @param channel 网络信道
     * @throws Exception 异常
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "order-queue",durable = "true"),
            exchange = @Exchange(name = "order-exchange",type = "topic"),
            key = "order.*"
    ))
    @RabbitHandler
    public void onOrderMessage(@Payload Order order, @Headers Map<String, Object> headers, Channel channel) throws Exception {
        // 消费者操作
        System.out.println("收到消息：");
        System.out.println("订单信息：" + order.toString());

        // 手动签收消息
        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        channel.basicAck(deliveryTag, false);
    }
}
