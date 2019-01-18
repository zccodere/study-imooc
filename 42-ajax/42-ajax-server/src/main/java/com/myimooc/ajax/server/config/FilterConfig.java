package com.myimooc.ajax.server.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <br>
 * 标题: 配置类<br>
 * 描述: 注册CrosFilter<br>
 *
 * @author zc
 * @date 2018/04/18
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean registrationBean(){
        FilterRegistrationBean filter = new FilterRegistrationBean();
        filter.addUrlPatterns("/*");
        filter.setFilter(new CrosFilter());
        return filter;
    }
}
