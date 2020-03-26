package com.myimooc.shiro.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 启动类；Spring Boot 集成 Shiro
 *
 * @author zc 2018-05-02
 */
@MapperScan("com.myimooc.shiro.web.dao")
@EnableAspectJAutoProxy
@SpringBootApplication
public class ShiroWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiroWebApplication.class, args);
    }
}
