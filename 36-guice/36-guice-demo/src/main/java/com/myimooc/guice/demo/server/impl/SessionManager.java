package com.myimooc.guice.demo.server.impl;

import com.google.inject.Provider;

import javax.inject.Inject;

/**
 * session管理类；模拟订单系统
 *
 * @author zc 2017-10-15
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
