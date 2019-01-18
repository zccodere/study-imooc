package com.myimooc.guice.demo.server.impl;

import javax.inject.Inject;

import com.google.inject.Provider;

/**
 * @title session管理类
 * @describe 模拟订单系统
 * @author zc
 * @version 1.0 2017-10-15
 */
public class SessionManager {
	
	private final Provider<Long> sessionIdProvider;
	
	@Inject
	public SessionManager(@SessionId Provider<Long> sessionIdProvider) {
		super();
		this.sessionIdProvider = sessionIdProvider;
	}

	public Long getSessionId() {
		return sessionIdProvider.get();
	}

}
