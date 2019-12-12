package com.myimooc.spring.auth.context;

import com.myimooc.spring.auth.entity.User;

/**
 * 保存当前登录用户的信息
 * @author zc on 2017-08-20
 */
public class UserContext {
	
	/**
	 * 将用户信息写入线程
	 */
	private static ThreadLocal<UserContext> tl = new ThreadLocal<UserContext>();
	
	private User user;
	
	private UserContext(User user){
		this.user = user;
	}
	
	static void setCurrent(User user){
		tl.set(new UserContext(user));
	}
	
	public static UserContext getCurrent(){
		return tl.get();
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static void remove(){
		tl.remove();
	}
	
}
