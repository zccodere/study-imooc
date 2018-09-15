package com.myimooc.sso.same.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * <br>
 * 标题: 启动类<br>
 * 描述: 启动类<br>
 * 时间: 2017/03/19<br>
 *
 * @author zc
 */
@SpringBootApplication
public class SameDomainApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SameDomainApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SameDomainApplication.class);
	}

}
