package com.myimooc.guice.spring.service.impl;

import com.google.inject.Inject;
import com.google.inject.servlet.RequestScoped;
import com.myimooc.guice.spring.service.MyDestination;

/**
 * @title WebDestination类
 * @describe 提供读和写的功能
 * @author zc
 * @version 1.0 2017-10-15
 */
@RequestScoped
public class WebDestination implements MyDestination {
	
	private final StringBuilder sb;
	
	@Inject
	public WebDestination(){
		System.out.println("WebDestination Constructed.");
		this.sb = new StringBuilder();
	}
	
	@Override
	public void write(String string) {
		sb.append(string);
	}

	public String getResult() {
		return sb.toString();
	}
}
