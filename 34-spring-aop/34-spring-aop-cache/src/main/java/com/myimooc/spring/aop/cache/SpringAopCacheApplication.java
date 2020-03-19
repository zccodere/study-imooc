package com.myimooc.spring.aop.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 启动类
 *
 * @author zc 2017-09-13
 */
@EnableCaching
@SpringBootApplication
public class SpringAopCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAopCacheApplication.class, args);
    }
}
