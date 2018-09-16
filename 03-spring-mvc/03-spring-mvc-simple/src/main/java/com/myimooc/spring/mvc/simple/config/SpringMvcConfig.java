package com.myimooc.spring.mvc.simple.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Web项目SpringMvc配置
 * @author zhangcheng
 * @version v1.0 2017-02-17
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.myimooc.springmvc")
public class SpringMvcConfig extends WebMvcConfigurerAdapter{
    
    /**
     * 配置SpringMvc视图解析器
     * @return 视图解析器
     */
    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/classes/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }
    
    /**
     * 配置静态资源映射
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
    
    /**
     * 配置SpringMvc文件上传解析器
     * @return 文件上传解析器
     */
    @Bean
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        // 设置文件上传大小，最大200M
        multipartResolver.setMaxUploadSize(209715200);
        multipartResolver.setDefaultEncoding("UTF-8");
        multipartResolver.setResolveLazily(true);
        return multipartResolver;
    }
    
}
