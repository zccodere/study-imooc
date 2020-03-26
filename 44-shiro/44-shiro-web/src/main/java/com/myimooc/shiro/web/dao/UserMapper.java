package com.myimooc.shiro.web.dao;

import com.myimooc.shiro.web.vo.User;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户 mapper
 *
 * @author zc 2018-05-02
 */
@Repository
public interface UserMapper {

    /**
     * 通过用户名获取用户信息
     *
     * @param userName 用户名
     * @return 用户信息
     */
    User getUserByUserName(String userName);

    /**
     * 通过用户名查询角色集合
     *
     * @param userName 用户名
     * @return 角色集合
     */
    List<String> queryRolesByUserName(String userName);
}
