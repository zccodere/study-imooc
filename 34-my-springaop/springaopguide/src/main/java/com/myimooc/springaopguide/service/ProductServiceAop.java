package com.myimooc.springaopguide.service;

import org.springframework.stereotype.Service;

import com.myimooc.springaopguide.domain.Product;
import com.myimooc.springaopguide.security.AdminOnly;

/**
 * @title 产品服务类
 * @describe 产品相关业务服务-AOP方式实现权限校验
 * @author zc
 * @version 1.0 2017-09-03
 */
@Service
public class ProductServiceAop {
	
	@AdminOnly
	public void insert(Product product){
		System.out.println("insert product");
	}
	
	@AdminOnly
	public void delete(Long id){
		System.out.println("delete product");
	}
	
}
