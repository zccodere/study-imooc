package com.myimooc.spring.aop.guide.service;

import com.myimooc.spring.aop.guide.security.CurrentUserHolder;

import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * 权限校验类；对用户权限进行校验
 *
 * @author zc 2017-09-03
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
