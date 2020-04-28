package com.myimooc.excel.boot.service;

import com.myimooc.excel.boot.domain.model.ImportData;
import com.myimooc.excel.boot.repository.ImportDataRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 数据导入服务层
 *
 * @author zc 2017-07-08
 */
@Service
public class ImportDataService {

    @Autowired
    private ImportDataRepository importDataRepository;

    public List<ImportData> list() {
        return importDataRepository.findAll();
    }

    public void save(ImportData importData) {
        importDataRepository.save(importData);
    }

    public ImportData findOne(Long id) {
        return importDataRepository.findById(id).orElse(null);
    }
}
