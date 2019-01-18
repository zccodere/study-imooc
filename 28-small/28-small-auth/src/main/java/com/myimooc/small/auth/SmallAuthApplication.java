package com.myimooc.small.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 慕课网-微信授权登录
 * 开发模式接入
 * @author ZhangCheng on 2017-08-12
 *
 */
@SpringBootApplication
public class SmallAuthApplication extends SpringBootServletInitializer
{
    public static void main( String[] args )
    {
        SpringApplication.run(SmallAuthApplication.class, args);
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SmallAuthApplication.class);
    }
}
