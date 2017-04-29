package com.imooc.ioc.interfaces;

import com.imooc.spring.ioc.interfaces.OneInterface;

public class OneInterfaceImpl implements OneInterface {
	
	public void say(String arg) {
		System.out.println("ServiceImpl say: " + arg);
	}

}
