package com.imooc.aop.schema.advisors.service;

import org.springframework.dao.PessimisticLockingFailureException;
import org.springframework.stereotype.Service;

@Service
public class InvokeService {
	
	public void invoke() {
		System.out.println("InvokeService ......");
	}
	
	public void invokeException() {
		throw new PessimisticLockingFailureException("");
	}

}
