package com.myimooc.boot.start.config;

import com.myimooc.boot.start.interceptor.OneInterceptor;
import com.myimooc.boot.start.interceptor.TwoInterceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 自定义配置类；注册自定义的拦截器
 *
 * @author zc 2018-04-26
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截器按照顺序执行
        registry.addInterceptor(new TwoInterceptor()).addPathPatterns("/two/**").addPathPatterns("/one/**");
        registry.addInterceptor(new OneInterceptor()).addPathPatterns("/one/**");
        super.addInterceptors(registry);
    }
}
