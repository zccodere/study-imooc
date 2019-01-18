package com.imooc.spring.ioc.injection.dao;

import com.imooc.ioc.injection.dao.InjectionDAO;

public class InjectionDAOImpl implements InjectionDAO {
	
	public void save(String arg) {
		//模拟数据库保存操作
		System.out.println("保存数据：" + arg);
	}

}
