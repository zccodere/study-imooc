package com.imooc.aop.dao;

import com.imooc.aop.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product,Long> {
    public Product findById(Long id);
}
