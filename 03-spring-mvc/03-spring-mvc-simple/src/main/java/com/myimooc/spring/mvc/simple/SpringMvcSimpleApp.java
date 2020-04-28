package com.myimooc.spring.mvc.simple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;

/**
 * 启动类
 *
 * @author zc 2020-03-14
 */
@SpringBootApplication(exclude = ThymeleafAutoConfiguration.class)
public class SpringMvcSimpleApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcSimpleApp.class, args);
    }

}
