package com.myimooc.spring.aop.guide.service;

import java.util.Objects;

import com.myimooc.spring.aop.guide.security.CurrentUserHolder;
import org.springframework.stereotype.Service;

/**
 * @author zc
 * @version 1.0 2017-09-03
 * @title 权限校验类
 * @describe 对用户权限进行校验
 */
@Service
public class AuthService {

    private static final String ROLE_ADMIN = "admin";

    public void checkAccess() {
        String user = CurrentUserHolder.get();
        if (!Objects.equals(ROLE_ADMIN, user)) {
            throw new RuntimeException("operation not allow");
        }
    }

}
