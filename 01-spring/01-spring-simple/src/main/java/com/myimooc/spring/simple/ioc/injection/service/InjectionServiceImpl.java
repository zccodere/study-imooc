package com.myimooc.spring.simple.ioc.injection.service;

import com.myimooc.spring.simple.ioc.injection.dao.InjectionDao;

/**
 * 服务接口实现
 *
 * @author zc 2017-01-18
 */
public class InjectionServiceImpl implements InjectionService {

    private InjectionDao injectionDao;

    /**
     * 构造器注入
     */
    public InjectionServiceImpl(InjectionDao injectionDao) {
        this.injectionDao = injectionDao;
    }

    /**
     * 设值注入
     */
    public void setInjectionDao(InjectionDao injectionDao) {
        this.injectionDao = injectionDao;
    }

    @Override
    public void save(String arg) {
        //模拟业务操作
        System.out.println("Service接收参数：" + arg);
        arg = arg + ":" + this.hashCode();
        injectionDao.save(arg);
    }

}
