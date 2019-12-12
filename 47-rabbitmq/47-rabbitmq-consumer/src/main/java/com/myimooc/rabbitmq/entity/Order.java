package com.myimooc.rabbitmq.entity;

import java.io.Serializable;

/**
 * <br>
 * 标题: 订单实体<br>
 * 描述: 订单实体<br>
 * 时间: 2018/09/06<br>
 *
 * @author zc
 */
public class Order implements Serializable{

    private static final long serialVersionUID = 6771608755338249746L;

    private String id;

    private String name;
    /**
     * 存储消息发送的唯一标识
     */
    private String messageId;

    public Order() {
    }

    public Order(String id, String name, String messageId) {
        this.id = id;
        this.name = name;
        this.messageId = messageId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", messageId='" + messageId + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
}
