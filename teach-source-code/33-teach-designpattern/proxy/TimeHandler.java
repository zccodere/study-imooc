package com.imooc.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TimeHandler implements InvocationHandler {

	private Object target;
	
	public TimeHandler(Object target) {
		super();
		this.target = target;
	}

	@Override
	public void invoke(Object o, Method m) {
		
		try {
			long starttime = System.currentTimeMillis();
			System.out.println("汽车开始行驶....");
			m.invoke(target);
			long endtime = System.currentTimeMillis();
			System.out.println("汽车结束行驶....  汽车行驶时间："
							+ (endtime - starttime) + "毫秒！");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
