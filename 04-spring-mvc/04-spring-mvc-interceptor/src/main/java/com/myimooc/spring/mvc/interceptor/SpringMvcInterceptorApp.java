package com.myimooc.spring.mvc.interceptor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;

/**
 * 启动类
 *
 * @author zc 2020-03-14
 */
@SpringBootApplication(exclude = ThymeleafAutoConfiguration.class)
public class SpringMvcInterceptorApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcInterceptorApp.class, args);
    }

}
