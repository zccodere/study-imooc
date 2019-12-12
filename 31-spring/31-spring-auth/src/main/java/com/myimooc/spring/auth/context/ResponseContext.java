package com.myimooc.spring.auth.context;

import javax.servlet.http.HttpServletResponse;

class ResponseContext {
	
	private static ThreadLocal<HttpServletResponse> tl = new ThreadLocal<HttpServletResponse>();
	
	public static void setCurrent(HttpServletResponse response){
		tl.set(response);
	}
	
	public static HttpServletResponse getCurrent(){
		return tl.get();
	}

	public static void remove(){
		tl.remove();
	}
}
