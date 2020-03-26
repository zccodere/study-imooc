package com.myimooc.shiro.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

/**
 * 测试类；测试认证的过程
 *
 * @author zc 2018-04-27
 */
public class AuthenticationTest {

    private SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();

    @Before
    public void init() {
        simpleAccountRealm.addAccount("Mark", "123456", "admin", "user");
    }

    @Test
    public void testAuthentication() {
        // 构建 SecurityManager
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(simpleAccountRealm);

        // 主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("Mark", "123456");
        subject.login(token);

        // 是否认证
        System.out.println("isAuthenticated:" + subject.isAuthenticated());

        // 检查用户是否具有某个角色
        subject.checkRole("admin");
        // 可以同时检查多个角色
        subject.checkRoles("admin", "user");

    }
}
