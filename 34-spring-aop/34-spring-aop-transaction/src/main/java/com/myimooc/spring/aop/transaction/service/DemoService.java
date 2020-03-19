package com.myimooc.spring.aop.transaction.service;

import com.myimooc.spring.aop.transaction.dao.OperationLogDao;
import com.myimooc.spring.aop.transaction.dao.UserDao;
import com.myimooc.spring.aop.transaction.domain.OperationLog;
import com.myimooc.spring.aop.transaction.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 业务服务
 *
 * @author zc 2017-09-13
 */
@Service
public class DemoService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private OperationLogDao operationLogDao;

    @Transactional(rollbackFor = Exception.class)
    public void addUser(String name) {
        OperationLog log = new OperationLog();
        log.setContent("create user:" + name);
        operationLogDao.save(log);

        User user = new User();
        user.setName(name);
        userDao.save(user);
    }

}
