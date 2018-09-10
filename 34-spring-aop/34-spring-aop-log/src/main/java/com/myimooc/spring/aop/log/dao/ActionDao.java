package com.myimooc.spring.aop.log.dao;

import com.myimooc.spring.aop.log.domain.Action;

/**
 * @title 操作记录DAO类
 * @describe 操作记录相关数据访问
 * @author zc
 * @version 1.0 2017-09-13
 */
public interface ActionDao {

	/**
	 * 保存
	 * @param action 操作实体类
	 */
	void save(Action action);
	
}
