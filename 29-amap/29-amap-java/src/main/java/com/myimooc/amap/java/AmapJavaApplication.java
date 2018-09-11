package com.myimooc.amap.java;

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
public class AmapJavaApplication extends SpringBootServletInitializer
{
    public static void main( String[] args )
    {
        SpringApplication.run(AmapJavaApplication.class, args);
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AmapJavaApplication.class);
    }
}
