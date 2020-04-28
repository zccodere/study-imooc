package com.myimooc.spring.aop.log;

import com.myimooc.spring.aop.log.dao.ProductDao;
import com.myimooc.spring.aop.log.domain.Product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 测试类
 *
 * @author zc 2017-09-13
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringAopLogApplicationTest {

    @Autowired
    private ProductDao productDao;

    @Test
    public void testInsert() {
        Product product = new Product();
        product.setName("dell computer");
        product.setOnlineTime(new Date());
        product.setBuyPrice(new BigDecimal("29.5"));
        product.setCategory("computer");
        product.setDetail("this is a dell notebook");
        product.setUpdateTime(new Date());
        productDao.save(product);
        System.out.println("new product id:" + product.getId());
    }

    @Test
    public void testUpdate() {
        Product product = productDao.findById(1L).orElseThrow(RuntimeException::new);
        product.setName("test-update");
        product.setBuyPrice(new BigDecimal("23.5"));
        product.setOnlineTime(new Date());
        productDao.save(product);
    }

    @Test
    public void testDelete() {
        productDao.deleteById(1L);
    }

}
