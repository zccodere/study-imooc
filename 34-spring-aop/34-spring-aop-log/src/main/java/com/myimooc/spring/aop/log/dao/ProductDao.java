package com.myimooc.spring.aop.log.dao;

import com.myimooc.spring.aop.log.domain.Product;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 产品DAO类；产品相关数据访问
 *
 * @author zc 2017-09-13
 */
public interface ProductDao extends JpaRepository<Product, Long> {

}
