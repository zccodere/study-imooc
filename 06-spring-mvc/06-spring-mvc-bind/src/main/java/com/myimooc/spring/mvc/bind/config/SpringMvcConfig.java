package com.myimooc.spring.mvc.bind.config;

import com.myimooc.spring.mvc.bind.common.MyDateConverter;
import com.myimooc.spring.mvc.bind.common.MyDateFormatter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Web项目SpringMvc配置
 * @author zhangcheng
 * @version v1.0 2017-02-19
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.myimooc.springmvcbind")
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
     * 配置全局类型转换器
     * @param registry
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        super.addFormatters(registry);
        registry.addFormatter(new MyDateFormatter());
        registry.addConverter(new MyDateConverter());
    }
}
