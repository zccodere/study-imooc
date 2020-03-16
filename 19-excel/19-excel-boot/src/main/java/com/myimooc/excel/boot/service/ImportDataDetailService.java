package com.myimooc.excel.boot.service;

import com.myimooc.excel.boot.domain.model.ImportData;
import com.myimooc.excel.boot.domain.model.ImportDataDetail;
import com.myimooc.excel.boot.repository.ImportDataDetailRepository;
import com.myimooc.excel.boot.repository.ImportDataRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 数据导入详情业务类
 *
 * @author zc 2017-07-08
 */
@Service
public class ImportDataDetailService {

    @Autowired
    private ImportDataRepository importDataRepository;
    @Autowired
    private ImportDataDetailRepository importDataDetailRepository;

    public List<ImportData> list() {
        return importDataRepository.findAll();
    }

    public void save(List<ImportDataDetail> importDataDetailList) {
        importDataDetailRepository.saveAll(importDataDetailList);
    }
}
