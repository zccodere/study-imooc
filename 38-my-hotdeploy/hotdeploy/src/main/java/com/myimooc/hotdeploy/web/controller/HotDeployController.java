package com.myimooc.hotdeploy.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @title 控制器
 * @describe 
 * @author zc
 * @version 1.0 2017-12-01
 */
@Controller
public class HotDeployController {
	
	// 等价于 @RequestMapping(value="/say",method=RequestMethod.GET)
	@GetMapping("/say")
	public String say(HttpServletRequest request){
		request.setAttribute("say", "Hello Spring Boot!");
		return "index";
	}
}
