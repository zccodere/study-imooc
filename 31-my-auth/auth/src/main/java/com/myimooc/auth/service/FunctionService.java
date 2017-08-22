package com.myimooc.auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myimooc.auth.dao.FunctionDao;
import com.myimooc.auth.entity.Function;

/**
 * 菜单功能服务
 * @author zc on 2017-08-19
 */
@Service
public class FunctionService {
	
	@Autowired
	private FunctionDao functionDao;
	
	public void addFunction(Function function){
		functionDao.save(function);
	}
	
	public void updateUrl(Long id,String url){
		functionDao.updateUrl(id, url);
	}
	
	public List<Function> getFunctions(int page,int size,Long parentId){
		return functionDao.findByPage(page, size, parentId);
	}
	
	public void deleteFunctionById(Long id){
		functionDao.deleteById(id);
	}
	
	public List<Function> getAllFunctions(){
		return functionDao.findAll();
	}
}
