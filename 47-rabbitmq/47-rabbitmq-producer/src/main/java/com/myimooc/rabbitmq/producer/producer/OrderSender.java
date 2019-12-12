package com.myimooc.rabbitmq.producer.producer;

import com.myimooc.rabbitmq.entity.Order;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <br>
 * 标题: 订单消息发送者<br>
 * 描述: 订单消息发送者<br>
 * 时间: 2018/09/06<br>
 *
 * @author zc
 */
@Component
public class OrderSender {

    private RabbitTemplate rabbitTemplate;

    @Autowired
    public OrderSender(
            RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    /**
     * 发送订单
     *
     * @param order 订单
     * @throws Exception 异常
     */
    public void send(Order order) throws Exception {

        CorrelationData correlationData = new CorrelationData();
        correlationData.setId(order.getMessageId());

        // exchange：交换机
        // routingKey：路由键
        // message：消息体内容
        // correlationData：消息唯一ID
        this.rabbitTemplate.convertAndSend("order-exchange", "order.a", order, correlationData);
    }

}
