package com.myimooc.rabbitmq.ha;

import com.myimooc.rabbitmq.entity.Order;
import com.myimooc.rabbitmq.ha.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

/**
 * <br>
 * 标题: 订单创建测试<br>
 * 描述: 订单创建测试<br>
 * 时间: 2018/09/07<br>
 *
 * @author zc
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void testCreateOrder(){
        Order order = new Order();
        order.setId(String.valueOf(System.currentTimeMillis()));
        order.setName("测试创建订单");
        order.setMessageId(System.currentTimeMillis() + "$" + UUID.randomUUID().toString().replaceAll("-",""));
        this.orderService.create(order);
    }

}