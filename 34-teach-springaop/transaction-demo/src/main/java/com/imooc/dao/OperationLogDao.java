package com.imooc.dao;

import com.imooc.domain.OperationLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationLogDao extends JpaRepository<OperationLog, Long> {
}
