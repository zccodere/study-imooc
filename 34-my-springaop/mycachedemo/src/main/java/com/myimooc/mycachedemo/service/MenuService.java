package com.myimooc.mycachedemo.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @title 菜单服务类
 * @describe 菜单业务服务
 * @author zc
 * @version 1.0 2017-09-13
 */
@Service
public class MenuService {
	
	@Cacheable(cacheNames={"menu"})
	public List<String> getMenuList(){
		System.out.println("");
		System.out.println("mock:get from db");
		return Arrays.asList("article","comment","admin");
	}
	
}
