package com.myimooc.jqueryqrcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 项目启动入口
 *
 */
@SpringBootApplication
public class App extends SpringBootServletInitializer
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(App.class);
    }
}
