package com.myimooc.mail.register.dao;

import com.myimooc.mail.register.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户资源层
 *
 * @author zc 2017-06-07
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * 通过code查询用户
     *
     * @param code code
     * @return 用户
     */
    User findByCode(String code);

}
