package com.myimooc.springquartz;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 项目控制器
 * @author ZhangCheng on 2017-06-28
 *
 */
@Controller
public class DemoController {
	
	@GetMapping(value={"","/"})
	public ModelAndView qrcode(){
		return new ModelAndView("/index");
	}
	
	/**
	 * 处理登录请求
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping("login")
	@ResponseBody
	private String hello(String username,String password){
		return "Hello " +username + " ,Your password is : " + password;
	}
}
