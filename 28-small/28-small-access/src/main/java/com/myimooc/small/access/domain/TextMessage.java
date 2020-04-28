package com.myimooc.small.access.domain;

/**
 * 文本消息-向微信接口发起请求Vo
 *
 * @author zc 2017-08-11
 */
public class TextMessage {

    private String toUserName;

    private String fromUserName;

    private Long createTime;

    private String msgType;

    private String content;

    private String msgId;

    @Override
    public String toString() {
        return "TextMessage [toUserName=" + toUserName + ", fromUserName=" + fromUserName + ", createTime=" + createTime
                + ", msgType=" + msgType + ", content=" + content + ", msgId=" + msgId + "]";
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }


}
