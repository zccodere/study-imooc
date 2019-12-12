package com.myimooc.spring.simple.resource;

import java.io.IOException;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;

/**
 * <br>
 * 标题: 模拟加载资源<br>
 * 描述: 模拟加载资源<br>
 * 时间: 2017/01/18<br>
 *
 * @author zc
 */
public class MoocResource implements ApplicationContextAware  {
	
	private ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}
	
	public void resource() throws IOException {
		Resource resource = applicationContext.getResource("config.txt");
		System.out.println(resource.getFilename());
		System.out.println(resource.contentLength());
	}

}
