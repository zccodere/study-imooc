package com.imooc.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class BeanLifeCycle implements InitializingBean, DisposableBean {
	
	public void defautInit() {
		System.out.println("Bean defautInit.");
	}
	
	public void defaultDestroy() {
		System.out.println("Bean defaultDestroy.");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Bean destroy.");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Bean afterPropertiesSet.");
	}
	
	public void start() {
		System.out.println("Bean start .");
	}
	
	public void stop() {
		System.out.println("Bean stop.");
	}
	
}
