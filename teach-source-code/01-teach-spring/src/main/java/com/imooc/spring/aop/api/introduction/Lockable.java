package com.imooc.spring.aop.api.introduction;

public interface Lockable {
	
	void lock();

	void unlock();

	boolean locked();

}
