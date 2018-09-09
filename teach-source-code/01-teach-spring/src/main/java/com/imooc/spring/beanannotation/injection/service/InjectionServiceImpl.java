package com.imooc.spring.beanannotation.injection.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imooc.beanannotation.injection.dao.InjectionDAO;
import com.imooc.beanannotation.injection.service.InjectionService;

@Service
public class InjectionServiceImpl implements InjectionService {
	
//	@Autowired
	private InjectionDAO injectionDAO;
	
	@Autowired
	public InjectionServiceImpl(InjectionDAO injectionDAO) {
		this.injectionDAO = injectionDAO;
	}
	
//	@Autowired
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
