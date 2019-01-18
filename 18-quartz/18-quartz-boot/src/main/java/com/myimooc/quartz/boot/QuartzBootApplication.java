package com.myimooc.quartz.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 项目入口类
 * @author ZhangCheng on 2017-06-28
 *
 */
@SpringBootApplication
public class QuartzBootApplication extends SpringBootServletInitializer
{
    public static void main( String[] args )
    {
        SpringApplication.run(QuartzBootApplication.class, args);
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(QuartzBootApplication.class);
    }
}
