package com.myimooc.java.watermark.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * ViewController 项目配置类
 * @author ZhangCheng on 2017-07-21
 *
 */
@Configuration
public class ViewControllerConfig extends WebMvcConfigurerAdapter{

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		
		registry.addViewController("/").setViewName("/index");
		registry.addViewController("").setViewName("/index");
		registry.addViewController("/index").setViewName("/index");
		registry.addViewController("/moreupload").setViewName("/moreupload");
	}
}
