package com.myimooc.spring.simple.ioc.injection.service;

import com.myimooc.spring.simple.ioc.injection.dao.InjectionDAO;

/**
 * <br>
 * 标题: 服务实现<br>
 * 描述: 服务实现<br>
 * 时间: 2017/01/18<br>
 *
 * @author zc
 */
public class InjectionServiceImpl implements InjectionService {

    private InjectionDAO injectionDAO;

    /**
     * 构造器注入
     *
     * @param injectionDAO
     */
    public InjectionServiceImpl(InjectionDAO injectionDAO) {
        this.injectionDAO = injectionDAO;
    }

    /**
     * 设值注入
     *
     * @param injectionDAO
     */
    public void setInjectionDAO(InjectionDAO injectionDAO) {
        this.injectionDAO = injectionDAO;
    }

    @Override
    public void save(String arg) {
        //模拟业务操作
        System.out.println("Service接收参数：" + arg);
        arg = arg + ":" + this.hashCode();
        injectionDAO.save(arg);
    }

}
