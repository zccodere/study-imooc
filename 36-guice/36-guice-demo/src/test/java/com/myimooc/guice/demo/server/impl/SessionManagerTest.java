package com.myimooc.guice.demo.server.impl;

import static org.junit.Assert.assertNotEquals;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;

/**
 * @title 测试类
 * @describe 测试@Provides
 * @author zc
 * @version 1.0 2017-10-15
 */
public class SessionManagerTest {
	
	@Inject
	SessionManager sessionManager;
	
	@Before
	public void setUp(){
		Guice.createInjector(new ServerModule())
			 .injectMembers(this);
	}
	
	@Test
	public void testGetSessionId() throws InterruptedException{
		Long sessionId1 = sessionManager.getSessionId();
		Thread.sleep(1000);
		Long sessionId2 = sessionManager.getSessionId();
		assertNotEquals(sessionId1.longValue(), sessionId2.longValue());
	}
	
}
