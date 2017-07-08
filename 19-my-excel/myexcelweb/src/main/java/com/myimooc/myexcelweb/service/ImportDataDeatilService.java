package com.myimooc.myexcelweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myimooc.myexcelweb.domain.model.ImportData;
import com.myimooc.myexcelweb.domain.model.ImportDataDetail;
import com.myimooc.myexcelweb.repository.ImportDataDetailRepository;
import com.myimooc.myexcelweb.repository.ImportDataRepository;

/**
 * 数据导入详情业务类
 * @author ZhangCheng on 2017-07-08
 *
 */
@Service
public class ImportDataDeatilService {
	
	@Autowired
	private ImportDataRepository importDataRepository;
	@Autowired
	private ImportDataDetailRepository importDataDetailRepository;
	
	public List<ImportData> list(){
		return importDataRepository.findAll();
	}
	
	public void save(List<ImportDataDetail> importDataDetailList){
		
		importDataDetailRepository.save(importDataDetailList);
		
	}
	
}
