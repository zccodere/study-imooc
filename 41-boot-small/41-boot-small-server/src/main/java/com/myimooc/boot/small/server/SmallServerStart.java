package com.myimooc.boot.small.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 * <p>慕课网《SpringBoot+MyBatis搭建迷你小程序》
 * SpringBoot 整合 Mybatis 时，必须加 @MapperScan</p>
 *
 * @author zc 2018-04-16
 */
@MapperScan("com.myimooc.boot.small.server.mapper")
@SpringBootApplication
public class SmallServerStart {

    public static void main(String[] args) {
        SpringApplication.run(SmallServerStart.class, args);
    }
}
