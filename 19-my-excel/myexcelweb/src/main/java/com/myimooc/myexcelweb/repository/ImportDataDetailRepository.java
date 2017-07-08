package com.myimooc.myexcelweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myimooc.myexcelweb.domain.model.ImportDataDetail;

/**
 * 数据导入详情资源接口
 * @author ZhangCheng on 2017-07-08
 *
 */
public interface ImportDataDetailRepository extends JpaRepository<ImportDataDetail, Long> {

}
