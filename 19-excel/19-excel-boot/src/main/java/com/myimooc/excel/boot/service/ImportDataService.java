package com.myimooc.excel.boot.service;

import java.util.List;

import com.myimooc.excel.boot.repository.ImportDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myimooc.excel.boot.domain.model.ImportData;

/**
 * 数据导入业务类
 * @author ZhangCheng on 2017-07-08
 *
 */
@Service
public class ImportDataService {
	
	@Autowired
	private ImportDataRepository importDataRepository;
	
	public List<ImportData> list(){
		return importDataRepository.findAll();
	}
	
	public void save(ImportData importData){
		importDataRepository.save(importData);
	}
	
	public ImportData findOne(Long id){
		return importDataRepository.findOne(id);
	}
}
