package com.myimooc.ssh.simple.service;

import com.myimooc.ssh.simple.dao.ProductDao;
import com.myimooc.ssh.simple.domain.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 商品管理的业务类
 *
 * @author zc 2017-08-17
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ProductService {

    /**
     * struts和spring整合，按名称自动装配
     */
    @Autowired
    private ProductDao productDao;

    /**
     * 业务层保存商品的方法
     */
    public void save(Product product) {
        System.out.println("Service中的save方法执行了...");
        productDao.save(product);

    }
}
