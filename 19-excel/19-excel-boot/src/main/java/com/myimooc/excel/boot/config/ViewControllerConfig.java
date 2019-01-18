package com.myimooc.excel.boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * ViewController 项目配置类
 * @author ZhangCheng on 2017-07-08
 *
 */
@Configuration
public class ViewControllerConfig extends WebMvcConfigurerAdapter{

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		
		registry.addViewController("/upload").setViewName("/upload");
		registry.addViewController("/student").setViewName("/student");
		registry.addViewController("/").setViewName("/main");
		registry.addViewController("/main").setViewName("/main");
	}
}
