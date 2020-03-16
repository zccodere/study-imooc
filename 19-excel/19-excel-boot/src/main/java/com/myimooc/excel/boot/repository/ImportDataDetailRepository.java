package com.myimooc.excel.boot.repository;

import com.myimooc.excel.boot.domain.model.ImportDataDetail;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 数据导入详情资源层
 *
 * @author zc 2017-07-08
 */
public interface ImportDataDetailRepository extends JpaRepository<ImportDataDetail, Long> {

}
