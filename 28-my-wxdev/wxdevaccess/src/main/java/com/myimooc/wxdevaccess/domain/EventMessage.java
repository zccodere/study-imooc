package com.myimooc.wxdevaccess.domain;

/**
 * 事件推送-向微信接口发起请求Vo
 * @author ZhangCheng on 2017-08-11
 *
 */
public class EventMessage {
	
	private String ToUserName;
	
	private String FromUserName;
	
	private Long CreateTime;
	
	private String MsgType;
	
	private String Event;
	
	@Override
	public String toString() {
		return "EventMessage [ToUserName=" + ToUserName + ", FromUserName=" + FromUserName + ", CreateTime="
				+ CreateTime + ", MsgType=" + MsgType + ", Event=" + Event + "]";
	}

	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public Long getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(Long createTime) {
		CreateTime = createTime;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	public String getEvent() {
		return Event;
	}

	public void setEvent(String event) {
		Event = event;
	}
	
	
	
}
