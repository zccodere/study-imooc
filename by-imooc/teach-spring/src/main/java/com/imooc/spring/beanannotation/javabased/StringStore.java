package com.imooc.spring.beanannotation.javabased;

import com.imooc.beanannotation.javabased.Store;

public class StringStore implements Store<String> {
	
	public void init() {
		System.out.println("This is init.");
	}
	
	public void destroy() {
		System.out.println("This is destroy.");
	}
	
}
