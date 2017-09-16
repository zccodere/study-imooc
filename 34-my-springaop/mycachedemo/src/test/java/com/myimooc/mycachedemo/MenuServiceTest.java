package com.myimooc.mycachedemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.myimooc.mycachedemo.service.MenuService;

/**
 * @title 菜单服务测试类
 * @describe 单元测试
 * @author zc
 * @version 1.0 2017-09-13
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuServiceTest {
	
	@Autowired
	private MenuService menuService;
	
	@Test
	public void testCache(){
		System.out.println("call:"+menuService.getMenuList());
		System.out.println("call:"+menuService.getMenuList());
	}
}
