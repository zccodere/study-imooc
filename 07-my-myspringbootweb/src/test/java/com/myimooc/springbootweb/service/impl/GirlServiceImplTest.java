package com.myimooc.springbootweb.service.impl;

import com.myimooc.springbootweb.model.entity.Girl;
import com.myimooc.springbootweb.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * GirlService单元测试类
 * @author ZhangCheng
 * @date 2017-03-19
 * @version V1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceImplTest {

    @Autowired
    private GirlService girlService;

    @Test
    public void findOne() throws Exception {
        Girl girl = girlService.findOne(7);
        Assert.assertEquals(new Integer(22),girl.getAge());
    }

}

