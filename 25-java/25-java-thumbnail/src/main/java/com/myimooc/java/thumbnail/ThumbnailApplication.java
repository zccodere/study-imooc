package com.myimooc.java.thumbnail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 项目入口类
 * @author ZhangCheng on 2017-07-19
 *
 */
@SpringBootApplication
public class ThumbnailApplication extends SpringBootServletInitializer
{
    public static void main( String[] args )
    {
        SpringApplication.run(ThumbnailApplication.class, args);
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ThumbnailApplication.class);
    }
}