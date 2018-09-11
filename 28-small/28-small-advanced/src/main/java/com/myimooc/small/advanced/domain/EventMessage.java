package com.myimooc.small.advanced.domain;

/**
 * 事件推送-向微信接口发起请求Vo
 *
 * @author ZhangCheng on 2017-08-11
 */
public class EventMessage extends BaseMessage {

    private String event;

    @Override
    public String toString() {
        return "EventMessage [event=" + event + "]";
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }


}
