package com.myimooc.excel.boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ViewController 项目配置类
 *
 * @author zc 2017-07-08
 */
@Configuration
public class ViewControllerConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/upload").setViewName("/upload");
        registry.addViewController("/student").setViewName("/student");
        registry.addViewController("/").setViewName("/main");
        registry.addViewController("/main").setViewName("/main");
    }
}
