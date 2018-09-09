package com.imooc.service;

import com.imooc.dao.OperationLogDao;
import com.imooc.dao.UserDao;
import com.imooc.domain.OperationLog;
import com.imooc.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by cat on 2017-03-12.
 */
@Component
public class DemoService {

    @Autowired
    UserDao userDao;

    @Autowired
    OperationLogDao operationLogDao;

    @Transactional
    public void addUser(String name){
        OperationLog log = new OperationLog();
        log.setContent("create user:"+name);
        operationLogDao.save(log);

        User user = new User();
        user.setName(name);
        userDao.save(user);
    }
}
