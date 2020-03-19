package com.myimooc.spring.aop.cache;

import com.myimooc.spring.aop.cache.service.MenuService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 菜单服务测试类
 *
 * @author zc 2017-09-13
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuServiceTest {

    @Autowired
    private MenuService menuService;

    @Test
    public void testCache() {
        System.out.println("call:" + menuService.getMenuList());
        System.out.println("call:" + menuService.getMenuList());
    }
}
