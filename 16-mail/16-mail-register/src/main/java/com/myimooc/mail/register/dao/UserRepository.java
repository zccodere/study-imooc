package com.myimooc.mail.register.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myimooc.mail.register.domain.User;

/**
 * <br>
 * 标题: 用户资源类<br>
 * 描述: 用户资源类<br>
 * 时间: 2017/06/07<br>
 *
 * @author zc
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
