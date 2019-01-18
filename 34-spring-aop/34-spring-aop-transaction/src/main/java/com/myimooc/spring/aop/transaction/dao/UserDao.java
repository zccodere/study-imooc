package com.myimooc.spring.aop.transaction.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myimooc.spring.aop.transaction.domain.User;

/**
 * @title 用户DAO类
 * @describe 用户相关数据访问类
 * @author zc
 * @version 1.0 2017-09-13
 */
public interface UserDao extends JpaRepository<User, Long> {

}
