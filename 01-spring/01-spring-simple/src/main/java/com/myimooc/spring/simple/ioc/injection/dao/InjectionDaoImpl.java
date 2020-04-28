package com.myimooc.spring.simple.ioc.injection.dao;

/**
 * DAO接口实现
 *
 * @author zc 2017-01-18
 */
public class InjectionDaoImpl implements InjectionDao {

    @Override
    public void save(String arg) {
        //模拟数据库保存操作
        System.out.println("保存数据：" + arg);
    }
}
