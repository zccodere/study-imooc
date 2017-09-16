package com.myimooc.springaopguide.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myimooc.springaopguide.domain.Product;

/**
 * @title 产品服务类
 * @describe 产品相关业务服务-传统方式实现权限校验
 * @author zc
 * @version 1.0 2017-09-03
 */
@Service
public class ProductService {
	
	@Autowired
	private AuthService AuthService;
	
	public void insert(Product product){
		AuthService.checkAccess();
		System.out.println("insert product");
	}
	
	public void delete(Long id){
		AuthService.checkAccess();
		System.out.println("delete product");
	}
	
}
