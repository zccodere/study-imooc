package com.myimooc.spring.aop.guide;

import com.myimooc.spring.aop.guide.security.CurrentUserHolder;
import com.myimooc.spring.aop.guide.service.ProductService;
import com.myimooc.spring.aop.guide.service.ProductServiceAop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试权限校验服务是否生效
 *
 * @author zc 2017-09-03
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AopGuideApplicationTest {

    @Autowired
    private ProductService productService;

    @Test(expected = Exception.class)
    public void annoInsertTest() {
        CurrentUserHolder.set("tom");
        productService.delete(1L);
    }

    @Test
    public void adminInsertTest() {
        CurrentUserHolder.set("admin");
        productService.delete(1L);
    }

    @Autowired
    private ProductServiceAop productServiceAop;

    @Test(expected = Exception.class)
    public void annoInsertAopTest() {
        CurrentUserHolder.set("tom");
        productServiceAop.delete(1L);
    }

    @Test
    public void adminInsertAopTest() {
        CurrentUserHolder.set("admin");
        productServiceAop.delete(1L);
    }

}
