package com.myimooc.transactiondemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myimooc.transactiondemo.dao.OperationLogDao;
import com.myimooc.transactiondemo.dao.UserDao;
import com.myimooc.transactiondemo.domain.OperationLog;
import com.myimooc.transactiondemo.domain.User;

/**
 * @title 业务服务
 * @describe 演示
 * @author zc
 * @version 1.0 2017-09-13
 */
@Service
public class DemoService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private OperationLogDao operationLogDao;
	
	@Transactional
	public void addUser(String name){
		OperationLog log = new OperationLog();
		log.setContent("create user:"+name);
		operationLogDao.save(log);
		
		User user = new User();
		user.setName(name);
		userDao.save(user);
	}
	
}
