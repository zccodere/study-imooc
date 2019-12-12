package com.myimooc.spring.auth.common;

/**
 * 是否枚举类
 * @author zc on 2017-08-19
 */
public enum Whether {
	/**
	 * 是
	 */
	YES(1),
	/**
	 * 否
	 */
	NO(0);
	
	private int value;
	
	Whether(int value){
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
