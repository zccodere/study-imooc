package com.myimooc.myexcelweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myimooc.myexcelweb.domain.model.ImportData;
import com.myimooc.myexcelweb.repository.ImportDataRepository;

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
