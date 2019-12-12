package com.myimooc.java.watermark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 项目入口类
 * @author ZhangCheng on 2017-07-21
 *
 */
@SpringBootApplication
public class WatermarkApplication extends SpringBootServletInitializer
{
    public static void main( String[] args )
    {
        SpringApplication.run(WatermarkApplication.class, args);
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WatermarkApplication.class);
    }
}
