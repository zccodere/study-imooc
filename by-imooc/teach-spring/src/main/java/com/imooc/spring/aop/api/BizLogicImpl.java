package com.imooc.spring.aop.api;

import com.imooc.aop.api.BizLogic;

public class BizLogicImpl implements BizLogic {
	
	public String save() {
		System.out.println("BizLogicImpl : BizLogicImpl save.");
		return "BizLogicImpl save.";
//		throw new RuntimeException();
	}

}
