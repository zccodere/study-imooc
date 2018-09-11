package com.myimooc.small.advanced;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 慕课网-Java微信公众号开发进阶
 * @author ZhangCheng on 2017-08-12
 *
 */
@SpringBootApplication
public class SmallAdvancedApplication extends SpringBootServletInitializer
{
    public static void main( String[] args )
    {
        SpringApplication.run(SmallAdvancedApplication.class, args);
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SmallAdvancedApplication.class);
    }
}
