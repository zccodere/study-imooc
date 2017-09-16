package com.myimooc.mydatalog.dao;

import com.myimooc.mydatalog.domain.Action;

/**
 * @title 操作记录DAO类
 * @describe 操作记录相关数据访问
 * @author zc
 * @version 1.0 2017-09-13
 */
public interface ActionDao {
	
	void save(Action action);
	
}
