package com.myimooc.boot.start.service.impl;

import com.github.pagehelper.PageHelper;
import com.myimooc.boot.start.dao.mapper.SysUserMapper;
import com.myimooc.boot.start.dao.mapper.SysUserMapperCustom;
import com.myimooc.boot.start.dao.po.SysUser;
import com.myimooc.boot.start.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

import java.util.List;

import tk.mybatis.mapper.entity.Example;

/**
 * 用户服务实现
 *
 * @author zc 2018-04-26
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysUserMapperCustom sysUserMapperCustom;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void create(SysUser user) {
        sysUserMapper.insert(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void update(SysUser user) {
        sysUserMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void remove(String userId) {
        sysUserMapper.deleteByPrimaryKey(userId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    public SysUser queryById(String userId) {
        return sysUserMapper.selectByPrimaryKey(userId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    public List<SysUser> queryUserList(SysUser user) {
        Example example = new Example(SysUser.class);
        Example.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmptyOrWhitespace(user.getUsername())) {
            criteria.andEqualTo("username", user.getUsername());
            criteria.andLike("username", "%" + user.getUsername() + "%");
        }
        if (!StringUtils.isEmptyOrWhitespace(user.getNickname())) {
            criteria.andLike("nickname", "%" + user.getNickname() + "%");
        }
        List<SysUser> userList = sysUserMapper.selectByExample(example);
        return userList;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    public List<SysUser> queryUserListPaged(SysUser user, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        Example example = new Example(SysUser.class);
        Example.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmptyOrWhitespace(user.getNickname())) {
            criteria.andLike("nickname", "%" + user.getNickname() + "%");
        }
        example.orderBy("registTime").desc();
        List<SysUser> userList = sysUserMapper.selectByExample(example);
        return userList;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    public SysUser queryUserByIdCustom(String userId) {
        List<SysUser> userList = sysUserMapperCustom.queryUserSimplyInfoById(userId);
        if (userList != null && !userList.isEmpty()) {
            return (SysUser) userList.get(0);
        }
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void saveUserTransactional(SysUser user) {
        sysUserMapper.insert(user);
        int a = 1 / 0;
        user.setIsDelete(1);
        sysUserMapper.updateByPrimaryKeySelective(user);
    }
}
