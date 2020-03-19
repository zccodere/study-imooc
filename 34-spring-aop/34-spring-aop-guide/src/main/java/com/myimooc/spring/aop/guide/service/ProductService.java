package com.myimooc.spring.aop.guide.service;

import com.myimooc.spring.aop.guide.domain.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 产品服务类；产品相关业务服务-传统方式实现权限校验
 *
 * @author zc 2017-09-03
 */
@Service
public class ProductService {

    @Autowired
    private AuthService authService;

    public void insert(Product product) {
        authService.checkAccess();
        System.out.println("insert product");
    }

    public void delete(Long id) {
        authService.checkAccess();
        System.out.println("delete product");
    }

}
