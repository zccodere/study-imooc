package com.myimooc.small;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * <br>
 * 标题: 启动应用<br>
 * 描述: 慕课网《SpringBoot+MyBatis搭建迷你小程序》<br>
 * SpringBoot 整合 Mybatis 时，必须加 @MapperScan
 *
 * @author zc
 * @date 2018/04/16
 */
@SpringBootApplication
@MapperScan("com.myimooc.small.mapper")
public class SmallStart {

	public static void main(String[] args) {
		SpringApplication.run(SmallStart.class, args);
	}
}
