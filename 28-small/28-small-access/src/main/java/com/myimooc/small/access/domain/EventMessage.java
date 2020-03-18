package com.myimooc.small.access.domain;

/**
 * 事件推送-向微信接口发起请求Vo
 *
 * @author zc 2017-08-11
 */
public class EventMessage {

    private String toUserName;

    private String fromUserName;

    private Long createTime;

    private String msgType;

    private String event;

    @Override
    public String toString() {
        return "EventMessage [toUserName=" + toUserName + ", fromUserName=" + fromUserName + ", createTime="
                + createTime + ", msgType=" + msgType + ", event=" + event + "]";
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

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }


}
