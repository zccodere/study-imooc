package com.myimooc.boot.start.service;

import com.myimooc.boot.start.dao.po.SysUser;

import java.util.List;

/**
 * <br>
 * 标题: 用户服务<br>
 * 描述: 用户服务<br>
 *
 * @author zc
 * @date 2018/04/26
 */
public interface UserService {

    void create(SysUser user);

    void update(SysUser user);

    void remove(String userId);

    SysUser queryById(String userId);

    List<SysUser> queryUserList(SysUser user);

    List<SysUser> queryUserListPaged(SysUser user, Integer page, Integer pageSize);

    SysUser queryUserByIdCustom(String userId);

    void saveUserTransactional(SysUser user);

}
