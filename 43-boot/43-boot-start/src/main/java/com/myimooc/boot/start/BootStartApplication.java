package com.myimooc.boot.start;

import org.n3r.idworker.Sid;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * <br>
 * 标题: 启动类<br>
 * 描述: 首个SpringBoot项目<br>
 * 使用 @EnableScheduling 开启支持定时任务
 * 使用 @EnableAsync 开启异步执行程序
 * @author zc
 * @date 2018/04/19
 */
@SpringBootApplication
@MapperScan("com.myimooc.boot.start.dao.mapper")
@EnableScheduling
@EnableAsync
public class BootStartApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootStartApplication.class, args);
    }

    @Bean
    public Sid sid() {
        return new Sid();
    }
}
