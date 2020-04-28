package com.myimooc.spring.aop.log.dao;

import com.myimooc.spring.aop.log.domain.Action;

import org.springframework.stereotype.Service;

/**
 * 操作记录DAO类实现类；操作记录相关数据访问
 *
 * @author zc 2017-09-13
 */
@Service
public class ActionDaoImpl implements ActionDao {

    @Override
    public void save(Action action) {
        System.out.println("模拟保存操作，保存成功");
        System.out.println("操作日志：" + action.toString());
    }

}
