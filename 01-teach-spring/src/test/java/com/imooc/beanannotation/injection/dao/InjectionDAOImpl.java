package com.imooc.beanannotation.injection.dao;

import org.springframework.stereotype.Repository;

import com.imooc.spring.beanannotation.injection.dao.InjectionDAO;

@Repository
public class InjectionDAOImpl implements InjectionDAO {
	
	public void save(String arg) {
		//模拟数据库保存操作
		System.out.println("保存数据：" + arg);
	}

}
