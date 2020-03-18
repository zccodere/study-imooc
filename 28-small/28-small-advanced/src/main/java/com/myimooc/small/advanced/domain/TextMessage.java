package com.myimooc.small.advanced.domain;

/**
 * 文本消息-向微信接口发起请求Vo
 *
 * @author zc 2017-08-11
 */
public class TextMessage extends BaseMessage {

    private String content;

    private String msgId;

    @Override
    public String toString() {
        return super.toString() + "TextMessage [content=" + content + ", msgId=" + msgId + "]";
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
