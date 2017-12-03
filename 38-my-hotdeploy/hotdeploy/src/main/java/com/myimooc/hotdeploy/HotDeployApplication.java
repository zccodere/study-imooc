package com.myimooc.hotdeploy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @title Spring Boot 热启动
 * @describe 启动类
 * @author zc
 * @version 1.0 2017-12-01
 */
@SpringBootApplication
public class HotDeployApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(HotDeployApplication.class, args);
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(HotDeployApplication.class);
    }
}
