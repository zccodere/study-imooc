package com.myimooc.spring.auth.service;

import com.myimooc.spring.auth.dao.FunctionDao;
import com.myimooc.spring.auth.entity.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 菜单功能服务
 *
 * @author zc 2017-08-19
 */
@Service
public class FunctionService {

    @Autowired
    private FunctionDao functionDao;

    public void addFunction(Function function) {
        functionDao.save(function);
    }

    public void updateUrl(Long id, String url) {
        functionDao.updateUrl(id, url);
    }

    public List<Function> getFunctions(int page, int size, Long parentId) {
        return functionDao.findByPage(page, size, parentId);
    }

    public void deleteFunctionById(Long id) {
        functionDao.deleteById(id);
    }

    public List<Function> getAllFunctions() {
        return functionDao.findAll();
    }
}
