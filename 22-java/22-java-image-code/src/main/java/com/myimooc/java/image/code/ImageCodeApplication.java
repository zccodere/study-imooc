package com.myimooc.java.image.code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 项目入口类
 * @author ZhangCheng on 2017-07-09
 *
 */
@SpringBootApplication
public class ImageCodeApplication extends SpringBootServletInitializer
{
    public static void main( String[] args )
    {
        SpringApplication.run(ImageCodeApplication.class, args);
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ImageCodeApplication.class);
    }
}