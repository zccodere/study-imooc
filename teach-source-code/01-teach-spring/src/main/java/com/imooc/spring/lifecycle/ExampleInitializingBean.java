package com.imooc.spring.lifecycle;

import org.springframework.beans.factory.InitializingBean;

public class ExampleInitializingBean implements InitializingBean {

	@Override
	public void afterPropertiesSet() throws Exception {
		//do something
	}

}
