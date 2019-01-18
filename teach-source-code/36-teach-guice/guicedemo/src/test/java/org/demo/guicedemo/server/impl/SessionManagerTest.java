package org.demo.guicedemo.server.impl;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;

public class SessionManagerTest {
	@Inject SessionManager sessionManager;

	@Before public void setUp() {
		Guice.createInjector(new ServerModule())
				.injectMembers(this);
	}

	@Test
	public void testGetSessionId() throws InterruptedException {
		Long sessionId1 = sessionManager.getSessionId();
		// Pretend we sleep long enough so session expires.
		Thread.sleep(1000);
		Long sessionId2 = sessionManager.getSessionId();
		assertNotEquals(
				sessionId2.longValue(), sessionId1.longValue());
	}

}
