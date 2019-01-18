package com.myimooc.spring.aop.proxy.chain;

import java.util.List;

/**
 * @title 责任链模式
 * @describe 封装链式关系
 * @author zc
 * @version 1.0 2017-09-13
 */
public class Chain {
	
	private List<AbstractChainHandler> handlers;
	
	private int index = 0;
	
	public Chain(List<AbstractChainHandler> handlers){
		this.handlers = handlers;
	}
	
	public void proceed(){
		if(index >= handlers.size()){
			return;
		}
		handlers.get(index++).execute(this);
	}
}
