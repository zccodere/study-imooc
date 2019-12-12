package com.myimooc.spring.aop.log.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myimooc.spring.aop.log.domain.Product;

/**
 * @title 产品DAO类
 * @describe 产品相关数据访问
 * @author zc
 * @version 1.0 2017-09-13
 */
public interface ProductDao extends JpaRepository<Product,Long> {
	/**
	 * 查找通过ID
	 * @param id ID
	 * @return 产品
	 */
	Product findById(Long id);

}
