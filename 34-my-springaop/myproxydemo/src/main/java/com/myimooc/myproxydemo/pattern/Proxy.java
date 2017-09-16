package com.myimooc.myproxydemo.pattern;

/**
 * @title 代理对象
 * @describe 同样也实现了Subject接口
 * @author zc
 * @version 1.0 2017-09-13
 */
public class Proxy implements Subject{
	
	// 需要引用目标对象
	private RealSubject realSubject;

	// 强制必须传入目标对象
	public Proxy(RealSubject realSubject) {
		this.realSubject = realSubject;
	}

	@Override
	public void request() {
		
		// 在目标对象方法执行之前做一些额外的事情
		System.out.println("before");
		
		try{
		
			// 代理对象不会做真实的业务逻辑，还是委托给真实的目标对象执行
			realSubject.request();
		}catch (Exception e) {
			System.out.println("ex:"+e.getMessage());
			throw e;
		}finally {
			
			// 在目标对象方法执行之后做一些额外的事情
			System.out.println("after");
		}
	}
}
