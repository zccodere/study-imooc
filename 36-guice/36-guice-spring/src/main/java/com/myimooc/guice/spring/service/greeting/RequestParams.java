package com.myimooc.guice.spring.service.greeting;

import com.google.inject.servlet.RequestScoped;

/**
 * @title POJO类
 * @describe 封装message信息
 * @author zc
 * @version 1.0 2017-10-15
 */
@RequestScoped
public class RequestParams {

	private String greetingName;

	public String getGreetingName() {
		return greetingName;
	}

	public void setGreetingName(String greetingName) {
		this.greetingName = greetingName;
	}
}
