package com.myimooc.spring.tx.my.demo1;

import com.myimooc.spring.tx.my.demo1.service.AccountService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 启动类
 *
 * @author zc 2020-03-14
 */
public class Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService service = applicationContext.getBean(AccountService.class);
        service.transfer("aaa", "bbb", 100D);
    }

}
