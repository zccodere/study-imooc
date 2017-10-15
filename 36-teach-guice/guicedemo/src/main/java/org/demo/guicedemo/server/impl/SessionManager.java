package org.demo.guicedemo.server.impl;

import javax.inject.Inject;

import com.google.inject.Provider;

public class SessionManager {
	private final Provider<Long> sessionIdProvider;

	@Inject
	public SessionManager(
			@SessionId Provider<Long> sessionIdProvider) {
		super();
		this.sessionIdProvider = sessionIdProvider;
	}

	public Long getSessionId() {
		return sessionIdProvider.get();
	}

}
