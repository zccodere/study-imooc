package com.myimooc.shiro.web;

import com.myimooc.shiro.web.filter.RolesOrFilter;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * <br>
 * 标题: 启动类<br>
 * 描述: SpirngBoot集成Shiro<br>
 *
 * @author zc
 * @date 2018/05/02
 */
@SpringBootApplication
@MapperScan("com.myimooc.shiro.web.dao")
@EnableAspectJAutoProxy
public class ShiroWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiroWebApplication.class,args);
    }
}
