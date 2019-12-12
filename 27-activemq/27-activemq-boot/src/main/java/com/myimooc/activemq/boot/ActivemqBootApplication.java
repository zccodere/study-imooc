package com.myimooc.activemq.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 项目入口类
 * @author ZhangCheng on 2017-07-22
 *
 */
@SpringBootApplication
public class ActivemqBootApplication extends SpringBootServletInitializer
{
    public static void main( String[] args )
    {
        SpringApplication.run(ActivemqBootApplication.class, args);
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ActivemqBootApplication.class);
    }
}
