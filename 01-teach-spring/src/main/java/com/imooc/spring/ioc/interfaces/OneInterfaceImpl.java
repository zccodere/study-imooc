package com.imooc.spring.ioc.interfaces;

import com.imooc.ioc.interfaces.OneInterface;

public class OneInterfaceImpl implements OneInterface {
	
	public void say(String arg) {
		System.out.println("ServiceImpl say: " + arg);
	}

}
