package com.myimooc.spring.aop.cache.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * 菜单业务服务
 *
 * @author zc  2017-09-13
 */
@Service
public class MenuService {

    @Cacheable(cacheNames = {"menu"})
    public List<String> getMenuList() {
        System.out.println("mock:get from db");
        return Arrays.asList("article", "comment", "admin");
    }

}
