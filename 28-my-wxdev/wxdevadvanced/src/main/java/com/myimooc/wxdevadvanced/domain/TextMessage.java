package com.myimooc.wxdevadvanced.domain;

/**
 * 文本消息-向微信接口发起请求Vo
 * @author ZhangCheng on 2017-08-11
 *
 */
public class TextMessage extends BaseMessage{
	
	private String Content;
	
	private String MsgId;

	@Override
	public String toString() {
		return super.toString() + "TextMessage [Content=" + Content + ", MsgId=" + MsgId + "]";
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public String getMsgId() {
		return MsgId;
	}

	public void setMsgId(String msgId) {
		MsgId = msgId;
	}
	
	
}
