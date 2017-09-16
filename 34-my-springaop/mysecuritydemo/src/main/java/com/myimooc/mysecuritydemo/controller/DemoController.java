package com.myimooc.mysecuritydemo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @title 控制器类
 * @describe 演示控制器类
 * @author zc
 * @version 1.0 2017-09-13
 */
@RestController
public class DemoController {
	
	@RequestMapping("/index")
	public String index(){
		return "index";
	}
	
	@RequestMapping("/common")
	public String commonAccess(){
		return "only login can view";
	}
	
	@RequestMapping("/admin")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String admin(){
		return "only admin can view";
	}
	
}
