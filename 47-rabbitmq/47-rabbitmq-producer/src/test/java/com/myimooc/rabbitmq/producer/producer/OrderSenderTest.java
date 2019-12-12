package com.myimooc.rabbitmq.producer.producer;

import com.myimooc.rabbitmq.entity.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

/**
 * <br>
 * 标题: 订单消息发送者测试<br>
 * 描述: 订单消息发送者测试<br>
 * 时间: 2018/09/06<br>
 *
 * @author zc
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderSenderTest {

    @Autowired
    private OrderSender orderSender;

    @Test
    public void testSend1() throws Exception {
        Order order = new Order();
        order.setId("201809062009010001");
        order.setName("测试订单1");
        order.setMessageId(System.currentTimeMillis() + "$" + UUID.randomUUID().toString().replaceAll("-",""));
        this.orderSender.send(order);
    }
}
