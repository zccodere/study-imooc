package com.myimooc.ajax.server.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类；注册CrosFilter
 *
 * @author zc 2018-04-18
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean registrationBean() {
        FilterRegistrationBean<CrosFilter> filter = new FilterRegistrationBean<>();
        filter.addUrlPatterns("/*");
        filter.setFilter(new CrosFilter());
        return filter;
    }
}
