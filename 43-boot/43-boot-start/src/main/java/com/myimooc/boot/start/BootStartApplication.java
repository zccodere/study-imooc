package com.myimooc.boot.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import tk.mybatis.spring.annotation.MapperScan;

/**
 * 启动类
 * <p>
 * 使用 @EnableScheduling 开启支持定时任务；使用 @EnableAsync 开启异步执行程序
 * </p>
 *
 * @author zc 2018-04-19
 */
@MapperScan("com.myimooc.boot.start.dao.mapper")
@EnableScheduling
@EnableAsync
@SpringBootApplication
public class BootStartApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootStartApplication.class, args);
    }
}
