package com.imooc.spring.lifecycle;

import org.springframework.beans.factory.DisposableBean;

public class ExampleDisposableBean implements DisposableBean {

	@Override
	public void destroy() throws Exception {
		//do something
	}

}
