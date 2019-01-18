package com.myimooc.amap.javascript.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * 视图配置类
 * @author ZhangCheng on 2017-08-14
 */
@Configuration
public class ViewConfig extends WebMvcConfigurerAdapter{
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("").setViewName("index");
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/index").setViewName("index");
		registry.addViewController("/wuxia").setViewName("wuxia");
	}
}
