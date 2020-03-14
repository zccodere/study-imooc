package com.myimooc.boot.simple.repository;

import com.myimooc.boot.simple.model.entity.Girl;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 资源层
 *
 * @author zc 2017-02-18
 */
public interface GirlRepository extends JpaRepository<Girl, Integer> {

    /**
     * 通过年龄来查询
     *
     * @param age 年龄
     * @return 实体
     */
    List<Girl> findByAge(Integer age);
}
