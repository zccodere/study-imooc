package com.myimooc.springaopguide.security;

/**
 * @title 获取用户信息
 * @describe 模拟用户的切换，将用户信息存入当前线程
 * @author zc
 * @version 1.0 2017-09-03
 */
public class CurrentUserHolder {
	
	private static final ThreadLocal<String> holder = new ThreadLocal<>();

	public static String get(){
		return holder.get() == null ? "unkown" : holder.get();
	}
	
	public static void set(String user){
		holder.set(user);
	}
}
