package com.myimooc.boot.web.repository;

import com.myimooc.boot.web.model.entity.Girl;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 资源层
 *
 * @author zc 2020-03-15
 */
public interface GirlRepository extends JpaRepository<Girl, Integer> {

    /**
     * 通过年龄来查询女生
     *
     * @param age 年龄
     * @return 女生
     */
    List<Girl> findByAge(Integer age);
}
