package com.myimooc.auth.common;

/**
 * 是否枚举类
 * @author zc on 2017-08-19
 */
public enum Whether {
	
	YES(1),
	NO(0);
	
	private int value;
	
	Whether(int value){
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
