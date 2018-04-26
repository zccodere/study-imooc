package com.myimooc.boot.start.dao.mapper;

import com.myimooc.boot.start.dao.po.SysUser;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <br>
 * 标题: 自定义 mapper<br>
 * 描述: 自定义mapper方法<br>
 *
 * @author zc
 * @date 2018/04/26
 */
@Repository
public interface SysUserMapperCustom {
	
	List<SysUser> queryUserSimplyInfoById(String id);
}