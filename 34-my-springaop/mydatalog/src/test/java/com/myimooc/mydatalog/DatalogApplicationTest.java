package com.myimooc.mydatalog;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.myimooc.mydatalog.dao.ProductDao;
import com.myimooc.mydatalog.domain.Product;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @title 5-2 案例实战
 * @describe 测试类
 * @author zc
 * @version 1.0 2017-09-13
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DatalogApplicationTest {

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
		System.out.println("new product id:"+product.getId());
	}

	@Test
	public void testUpdate(){
		Product product = productDao.findOne(1L);
		product.setName("test-update");
		product.setBuyPrice(new BigDecimal("23.5"));
		product.setOnlineTime(new Date());
		productDao.save(product);
	}

	@Test
	public void testDelete(){
		productDao.delete(1L);
	}

}
