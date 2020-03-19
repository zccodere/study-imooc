package com.myimooc.spring.aop.transaction.dao;

import com.myimooc.spring.aop.transaction.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户DAO类；用户相关数据访问类
 *
 * @author zc 2017-09-13
 */
public interface UserDao extends JpaRepository<User, Long> {

}
