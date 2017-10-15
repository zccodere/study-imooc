package org.demo.guicedemo.server.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.inject.Singleton;

import com.google.common.cache.AbstractCache;

@Singleton
public class GuiceDemoCache
	extends AbstractCache<String, String> {

	private final Map<String, String> keyValues =
			new ConcurrentHashMap<>();

	@Override
	public String getIfPresent(Object key) {
		return keyValues.get(key);
	}

	@Override
	public void put(String key, String value) {
		keyValues.put(key, value);
	}
}
