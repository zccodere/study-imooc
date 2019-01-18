package com.myimooc.excel.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 项目入口类
 * @author ZhangCheng on 2017-07-08
 *
 */
@SpringBootApplication
public class ExcelBootApplication extends SpringBootServletInitializer
{
    public static void main( String[] args )
    {
        SpringApplication.run(ExcelBootApplication.class, args);
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ExcelBootApplication.class);
    }
}
