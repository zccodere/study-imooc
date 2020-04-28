package com.myimooc.rabbitmq.ha.dao.mapper;

import com.myimooc.rabbitmq.ha.dao.po.BrokerMessageLogPO;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 表 broker_message_log Mapper
 *
 * @author zc
 * @date 2018/09/07
 */
@Repository
public interface BrokerMessageLogMapper {

    /**
     * 创建消息日志
     *
     * @param messageLog 消息日志
     */
    void insert(BrokerMessageLogPO messageLog);

    /**
     * 更新消息状态
     *
     * @param messageLog 消息日志
     */
    void changeBrokerMessageLogStatus(BrokerMessageLogPO messageLog);

    /**
     * 查询消息状态为0 且 已经超时的消息
     *
     * @return 消息日志集合
     */
    List<BrokerMessageLogPO> listSendFailureAndTimeoutMessage();

    /**
     * 更新重试次数+1
     *
     * @param po 消息日志
     */
    void updateRetryCount(BrokerMessageLogPO po);
}
