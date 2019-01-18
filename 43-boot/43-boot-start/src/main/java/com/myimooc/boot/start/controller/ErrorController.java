package com.myimooc.boot.start.controller;

import com.myimooc.boot.start.domain.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <br>
 * 标题: 错误页演示<br>
 * 描述: 跳转至错误页<br>
 *
 * @author zc
 * @date 2018/04/25
 */
@Controller
@RequestMapping("err")
public class ErrorController {

	@RequestMapping("/error")
	public String error() {
		int a = 1 / 0;
		return "thymeleaf/error";
	}
	
	@RequestMapping("/ajaxerror")
	public String ajaxerror() {
		return "thymeleaf/ajaxerror";
	}
	
	@RequestMapping("/getAjaxerror")
	@ResponseBody
	public JsonResult getAjaxerror() {
		int a = 1 / 0;
		return JsonResult.ok();
	}
}
