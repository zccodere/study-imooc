package com.myimooc.boot.start.dao.mapper;

import com.myimooc.boot.start.dao.po.SysUser;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 自定义 mapper 方法<
 *
 * @author zc 2018-04-26
 */
@Repository
public interface SysUserMapperCustom {

    /**
     * 通过ID查询用户
     *
     * @param id ID
     * @return 用户集合
     */
    List<SysUser> queryUserSimplyInfoById(String id);
}
