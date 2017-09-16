package com.myimooc.myproxydemo.chain;

import java.util.Arrays;
import java.util.List;

/**
 * @title 责任链模式
 * @describe 有顺序的链式调用测试类
 * @author zc
 * @version 1.0 2017-09-13
 */
public class ChainClient {
	
	static class ChainHandlerA extends ChainHandler{
		@Override
		protected void handleProcess() {
			System.out.println("handle by a");
		}
	}
	static class ChainHandlerB extends ChainHandler{
		@Override
		protected void handleProcess() {
			System.out.println("handle by b");
		}
	}
	static class ChainHandlerC extends ChainHandler{
		@Override
		protected void handleProcess() {
			System.out.println("handle by c");
		}
	}
	
	public static void main(String[] args) {
		// 声明链式调用顺序
		List<ChainHandler> handlers = Arrays.asList(
			new ChainHandlerA(),
			new ChainHandlerB(),
			new ChainHandlerC()
		);
		
		Chain chain = new Chain(handlers);
		chain.proceed();
	}
}
