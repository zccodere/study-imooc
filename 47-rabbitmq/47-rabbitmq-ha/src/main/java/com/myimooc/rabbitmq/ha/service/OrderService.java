package com.myimooc.rabbitmq.ha.service;

import com.myimooc.rabbitmq.entity.Order;
import com.myimooc.rabbitmq.ha.constant.Constants;
import com.myimooc.rabbitmq.ha.dao.mapper.BrokerMessageLogMapper;
import com.myimooc.rabbitmq.ha.dao.mapper.OrderMapper;
import com.myimooc.rabbitmq.ha.dao.po.BrokerMessageLogPO;
import com.myimooc.rabbitmq.ha.producer.OrderSender;
import com.myimooc.rabbitmq.ha.util.FastJsonConvertUtils;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 订单服务
 *
 * @author zc
 * @date 2018/09/07
 */
@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private BrokerMessageLogMapper brokerMessageLogMapper;
    @Autowired
    private OrderSender orderSender;

    /**
     * 创建订单
     *
     * @param order 订单
     */
    public void create(Order order) {
        // 当前时间
        Date orderTime = new Date();
        // 业务数据入库
        this.orderMapper.insert(order);
        // 消息日志入库
        BrokerMessageLogPO messageLog = new BrokerMessageLogPO();
        messageLog.setMessageId(order.getMessageId());
        messageLog.setMessage(FastJsonConvertUtils.convertObjectToJson(order));
        messageLog.setTryCount(0);
        messageLog.setStatus(Constants.OrderSendStatus.SENDING);
        messageLog.setNextRetry(DateUtils.addMinutes(orderTime, Constants.ORDER_TIMEOUT));
        this.brokerMessageLogMapper.insert(messageLog);
        // 发送消息
        this.orderSender.send(order);
    }
}
