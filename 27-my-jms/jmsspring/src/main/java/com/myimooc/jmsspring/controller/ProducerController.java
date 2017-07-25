package com.myimooc.jmsspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myimooc.jmsspring.producer.ProducerService;

/**
 * 消息服务控制类
 * @author ZhangCheng on 2017-07-22
 *
 */
@Controller
@RequestMapping("/send")
public class ProducerController {
	
	@Autowired
	private ProducerService producerService;
	
	@RequestMapping("/queue")
	@ResponseBody
	public Object sendMessageQueue(String message){
		producerService.sendMessageQueue(message);
		return true;
	}
	
	@RequestMapping("/topic")
	@ResponseBody
	public Object sendMessageTopic(String message){
		producerService.sendMessageTopic(message);
		return true;
	}
}
