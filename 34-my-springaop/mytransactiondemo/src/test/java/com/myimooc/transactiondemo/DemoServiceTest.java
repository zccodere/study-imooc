package com.myimooc.transactiondemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.myimooc.transactiondemo.service.DemoService;

/**
 * @title 业务服务测试类
 * @describe 演示
 * @author zc
 * @version 1.0 2017-09-13
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoServiceTest {
	
	@Autowired
	private DemoService demoService;
	
	@Test
	public void testWithoutTransaction(){
		demoService.addUser("tom");
	}
	
}
