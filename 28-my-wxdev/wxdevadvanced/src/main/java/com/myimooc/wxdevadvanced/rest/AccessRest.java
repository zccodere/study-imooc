package com.myimooc.wxdevadvanced.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myimooc.wxdevadvanced.domain.AccressReqVo;
import com.myimooc.wxdevadvanced.util.CheckUtils;

/**
 * 开发模式接入
 * @author ZhangCheng on 2017-08-11
 *
 */
@RestController
public class AccessRest {
	
	/**
	 * 接收微信服务器发送的GET验证请求
	 */
	@GetMapping("wx")
	public String access(AccressReqVo vo){
		if(CheckUtils.checkSignature(vo)){
			return vo.getEchostr();
		}
		return "error";
	}
}
