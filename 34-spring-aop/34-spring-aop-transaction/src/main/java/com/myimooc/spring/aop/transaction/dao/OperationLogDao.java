package com.myimooc.spring.aop.transaction.dao;

import com.myimooc.spring.aop.transaction.domain.OperationLog;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 操作日志DAO类；操作日志相关数据访问类
 *
 * @author zc 2017-09-13
 */
public interface OperationLogDao extends JpaRepository<OperationLog, Long> {

}
