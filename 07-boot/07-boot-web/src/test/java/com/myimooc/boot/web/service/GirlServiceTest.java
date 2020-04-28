package com.myimooc.boot.web.service;

import com.myimooc.boot.web.AbstractTestSupport;
import com.myimooc.boot.web.model.entity.Girl;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 服务层测试类
 *
 * @author zc 2017-03-19
 */
public class GirlServiceTest extends AbstractTestSupport {

    @Autowired
    private GirlService girlService;

    @Test
    public void findOne() {
        Girl girl = girlService.findOne(7);
        Assert.assertEquals(new Integer(22), girl.getAge());
    }
}