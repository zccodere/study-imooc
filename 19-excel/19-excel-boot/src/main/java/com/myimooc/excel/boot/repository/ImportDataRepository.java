package com.myimooc.excel.boot.repository;

import com.myimooc.excel.boot.domain.model.ImportData;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 数据导入资源层
 *
 * @author zc 2017-07-08
 */
public interface ImportDataRepository extends JpaRepository<ImportData, Long> {

}
