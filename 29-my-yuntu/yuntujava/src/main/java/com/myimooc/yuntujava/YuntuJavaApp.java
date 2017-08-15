package com.myimooc.yuntujava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 项目启动入口
 * 慕课网-如何使用高德云图在线制作属于你的地图-Java开发实战
 * @author ZhangCheng on 2017-08-13
 */
@SpringBootApplication
public class YuntuJavaApp extends SpringBootServletInitializer
{
    public static void main( String[] args )
    {
        SpringApplication.run(YuntuJavaApp.class, args);
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(YuntuJavaApp.class);
    }
}
