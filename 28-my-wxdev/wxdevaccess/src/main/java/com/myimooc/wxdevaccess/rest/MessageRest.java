package com.myimooc.wxdevaccess.rest;

import java.util.Date;
import java.util.Objects;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myimooc.wxdevaccess.domain.EventMessage;
import com.myimooc.wxdevaccess.domain.TextMessage;
import com.myimooc.wxdevaccess.util.MessageUtils;

/**
 * 处理消息请求与响应
 * @author ZhangCheng on 2017-08-11
 *
 */
@RestController
public class MessageRest {
	
	/**
	 * 接收微信服务器发送的POST请求
	 */
	@PostMapping("textmessage")
	public Object textmessage(TextMessage msg){
		// 文本消息
		if(Objects.equals(MessageUtils.MESSAGE_TEXT, msg.getMsgType())){
			TextMessage textMessage = new TextMessage();
			// 关键字 1
			if(Objects.equals("1", msg.getContent())){
				textMessage = MessageUtils.initText(msg.getToUserName(), msg.getFromUserName(), MessageUtils.firstMenu());
				return textMessage;
			}
			// 关键字 2
			if(Objects.equals("2", msg.getContent())){
				textMessage = MessageUtils.initText(msg.getToUserName(), msg.getFromUserName(), MessageUtils.secondMenu());
				return textMessage;
			}
			// 关键字 ？? 调出菜单
			if(Objects.equals("？", msg.getContent()) || Objects.equals("?", msg.getContent())){
				textMessage = MessageUtils.initText(msg.getToUserName(), msg.getFromUserName(), MessageUtils.menuText());
				return textMessage;
			}
			
			// 非关键字
			textMessage.setFromUserName(msg.getToUserName());
			textMessage.setToUserName(msg.getFromUserName());
			textMessage.setMsgType(MessageUtils.MESSAGE_TEXT);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setContent("您发送的消息是：" + msg.getContent());
			return textMessage;
		}
		return null;
	}
	
	/**
	 * 接收微信服务器发送的POST请求
	 */
	@PostMapping("eventmessage")
	public Object eventmessage(EventMessage msg){
		// 事件推送
		if(Objects.equals(MessageUtils.MESSAGE_EVENT, msg.getMsgType())){
			// 关注
			if(Objects.equals(MessageUtils.MESSAGE_SUBSCRIBE, msg.getEvent())){
				TextMessage text = new TextMessage();
				text = MessageUtils.initText(msg.getToUserName(), msg.getFromUserName(), MessageUtils.menuText());
				return text;
			}
		}
		return null;
	}
	
}
