package com.myimooc.rabbitmq.ha.dao.po;

import java.io.Serializable;
import java.util.Date;

/**
 * <br>
 * 标题: 消息日志<br>
 * 描述: 消息日志<br>
 * 时间: 2018/09/06<br>
 *
 * @author zc
 */
public class BrokerMessageLogPO implements Serializable {

    private static final long serialVersionUID = 5759863465976787292L;
    /**
     * 消息ID
     */
    private String messageId;
    /**
     * 消息内容
     */
    private String message;
    /**
     * '重试次数'
     */
    private Integer tryCount;
    /**
     * 投递状态 {@code com.myimooc.rabbitmq.ha.constant.Constants.OrderSendStatus}
     */
    private String status;
    /**
     * 下次重试时间
     */
    private Date nextRetry;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

    @Override
    public String toString() {
        return "BrokerMessageLogPO{" +
                "messageId='" + messageId + '\'' +
                ", message='" + message + '\'' +
                ", tryCount=" + tryCount +
                ", status='" + status + '\'' +
                ", nextRetry=" + nextRetry +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getTryCount() {
        return tryCount;
    }

    public void setTryCount(Integer tryCount) {
        this.tryCount = tryCount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getNextRetry() {
        return nextRetry;
    }

    public void setNextRetry(Date nextRetry) {
        this.nextRetry = nextRetry;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}