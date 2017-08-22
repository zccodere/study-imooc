package com.myimooc.auth.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class WebApplicationContext implements ApplicationContextAware {

	private static ApplicationContext ctx;
	
	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		ctx = context;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T> T getBean(Class clazz){
		return (T)ctx.getBean(clazz);
	}
}
