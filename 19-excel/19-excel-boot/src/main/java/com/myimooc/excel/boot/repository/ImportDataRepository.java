package com.myimooc.excel.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myimooc.excel.boot.domain.model.ImportData;

/**
 * 数据导入资源接口
 * @author ZhangCheng on 2017-07-08
 *
 */
public interface ImportDataRepository extends JpaRepository<ImportData, Long> {
	
	
	
}
