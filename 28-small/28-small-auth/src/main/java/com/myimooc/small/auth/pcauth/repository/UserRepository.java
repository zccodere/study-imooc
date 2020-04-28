package com.myimooc.small.auth.pcauth.repository;

import com.myimooc.small.auth.pcauth.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户相关资源类
 *
 * @author zc 2017-08-12
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 查询用户通过唯一标识
     *
     * @param unionId 唯一标识
     * @return 用户
     */
    User findByUnionid(String unionId);

}
