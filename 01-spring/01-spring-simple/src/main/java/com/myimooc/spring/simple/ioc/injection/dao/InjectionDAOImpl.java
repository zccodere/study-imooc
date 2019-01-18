package com.myimooc.spring.simple.ioc.injection.dao;

/**
 * <br>
 * 标题: DAO实现<br>
 * 描述: DAO接口<br>
 * 时间: 2017/01/18<br>
 *
 * @author zc
 */
public class InjectionDAOImpl implements InjectionDAO {

    @Override
    public void save(String arg) {
        //模拟数据库保存操作
        System.out.println("保存数据：" + arg);
    }
}
