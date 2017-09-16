package com.myimooc.transactiondemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myimooc.transactiondemo.domain.OperationLog;

/**
 * @title 操作日志DAO类
 * @describe 操作日志相关数据访问类
 * @author zc
 * @version 1.0 2017-09-13
 */
public interface OperationLogDao extends JpaRepository<OperationLog, Long> {

}
