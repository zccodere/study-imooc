package com.myimooc.deploy.hot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @author zc
 * @version 1.0 2017-12-01
 * @title Spring Boot 热启动
 * @describe 启动类
 */
@SpringBootApplication
public class DeployHotApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DeployHotApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DeployHotApplication.class);
    }
}
