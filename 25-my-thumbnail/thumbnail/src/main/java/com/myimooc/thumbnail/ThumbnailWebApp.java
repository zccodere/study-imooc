package com.myimooc.thumbnail;

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
public class ThumbnailWebApp extends SpringBootServletInitializer
{
    public static void main( String[] args )
    {
        SpringApplication.run(ThumbnailWebApp.class, args);
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ThumbnailWebApp.class);
    }
}