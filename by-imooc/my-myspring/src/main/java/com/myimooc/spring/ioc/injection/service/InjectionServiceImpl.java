package com.myimooc.spring.ioc.injection.service;

import com.myimooc.spring.ioc.injection.dao.InjectionDAO;

public class InjectionServiceImpl implements InjectionService {
	
	private InjectionDAO injectionDAO;
	
	//构造器注入
	public InjectionServiceImpl(InjectionDAO injectionDAO1) {
		this.injectionDAO = injectionDAO1;
	}
	
	//设值注入
	public void setInjectionDAO(InjectionDAO injectionDAO) {
		this.injectionDAO = injectionDAO;
	}

	public void save(String arg) {
		//模拟业务操作
		System.out.println("Service接收参数：" + arg);
		arg = arg + ":" + this.hashCode();
		injectionDAO.save(arg);
	}
	
}
