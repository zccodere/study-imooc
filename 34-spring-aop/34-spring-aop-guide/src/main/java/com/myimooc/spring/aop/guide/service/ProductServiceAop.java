package com.myimooc.spring.aop.guide.service;

import com.myimooc.spring.aop.guide.domain.Product;
import com.myimooc.spring.aop.guide.security.AdminOnly;

import org.springframework.stereotype.Service;

/**
 * 产品服务类；产品相关业务服务-AOP方式实现权限校验
 *
 * @author zc 2017-09-03
 */
@Service
public class ProductServiceAop {

    @AdminOnly
    public void insert(Product product) {
        System.out.println("insert product");
    }

    @AdminOnly
    public void delete(Long id) {
        System.out.println("delete product");
    }

}
