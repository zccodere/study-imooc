package com.myimooc.spring.mvc.bind.config;

import com.myimooc.spring.mvc.bind.common.MyDateConverter;
import com.myimooc.spring.mvc.bind.common.MyDateFormatter;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Web项目SpringMvc配置
 *
 * @author zc 2017-02-19
 */
@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {

    /**
     * 配置全局类型转换器
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new MyDateFormatter());
        registry.addConverter(new MyDateConverter());
    }
}
