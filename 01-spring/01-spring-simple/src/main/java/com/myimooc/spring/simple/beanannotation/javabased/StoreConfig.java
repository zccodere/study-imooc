package com.myimooc.spring.simple.beanannotation.javabased;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * 配置
 *
 * @author zc 2017-01-18
 */
@Configuration
@ImportResource("classpath:config.xml")
public class StoreConfig {

    @Autowired
    private Store<String> s1;

    @Autowired
    private Store<Integer> s2;

    @Bean
    public StringStore stringStore() {
        return new StringStore();
    }

    @Bean
    public IntegerStore integerStore() {
        return new IntegerStore();
    }

//    @Bean(name = "stringStoreTest")
//    public Store stringStoreTest() {
//        System.out.println("s1 : " + s1.getClass().getName());
//        System.out.println("s2 : " + s2.getClass().getName());
//        return new StringStore();
//    }

}
