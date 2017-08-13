package com.myimooc.wxdevadvanced.domain;

/**
 * 事件推送-向微信接口发起请求Vo
 * @author ZhangCheng on 2017-08-11
 *
 */
public class EventMessage extends BaseMessage{
	
	private String Event;
	
	@Override
	public String toString() {
		return "EventMessage [Event=" + Event + "]";
	}

	public String getEvent() {
		return Event;
	}

	public void setEvent(String event) {
		Event = event;
	}
	
	
	
}
