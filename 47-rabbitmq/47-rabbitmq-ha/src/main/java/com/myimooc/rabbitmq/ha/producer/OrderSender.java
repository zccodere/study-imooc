package com.myimooc.rabbitmq.ha.producer;

import com.myimooc.rabbitmq.entity.Order;
import com.myimooc.rabbitmq.ha.constant.Constants;
import com.myimooc.rabbitmq.ha.dao.mapper.BrokerMessageLogMapper;
import com.myimooc.rabbitmq.ha.dao.po.BrokerMessageLogPO;
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

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private BrokerMessageLogMapper brokerMessageLogMapper;
    /**
     * 回调方法：confirm确认
     */
    private final RabbitTemplate.ConfirmCallback confirmCallback = new RabbitTemplate.ConfirmCallback() {
        @Override
        public void confirm(CorrelationData correlationData, boolean ack, String cause) {
            System.out.println("correlationData：" + correlationData);
            String messageId = correlationData.getId();
            if (ack) {
                // 如果confirm返回成功，则进行更新
                BrokerMessageLogPO messageLogPO = new BrokerMessageLogPO();
                messageLogPO.setMessageId(messageId);
                messageLogPO.setStatus(Constants.OrderSendStatus.SEND_SUCCESS);
                brokerMessageLogMapper.changeBrokerMessageLogStatus(messageLogPO);
            } else {
                // 失败则进行具体的后续操作：重试或者补偿等
                System.out.println("异常处理...");
            }
        }
    };

    /**
     * 发送订单
     *
     * @param order 订单
     */
    public void send(Order order) {
        // 设置回调方法
        this.rabbitTemplate.setConfirmCallback(confirmCallback);
        // 消息ID
        CorrelationData correlationData = new CorrelationData(order.getMessageId());
        // 发送消息
        this.rabbitTemplate.convertAndSend("order-exchange", "order.a", order, correlationData);
    }
}
