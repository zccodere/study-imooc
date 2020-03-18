package com.myimooc.small.advanced.domain;

/**
 * 基础消息
 *
 * @author zc 2017-08-12
 */
public class BaseMessage {

    private String toUserName;

    private String fromUserName;

    private String createTime;

    private String msgType;

    @Override
    public String toString() {
        return "BaseMessage [toUserName=" + toUserName + ", fromUserName=" + fromUserName + ", createTime=" + createTime
                + ", msgType=" + msgType + "]";
    }

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }


}
