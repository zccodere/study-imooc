package com.myimooc.shiro.test;

import com.myimooc.shiro.test.realm.CustomRealm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * 自定义Realm测试；测试自定义Realm
 *
 * @author zc 2018-05-02
 */
public class CustomRealmTest {

    @Test
    public void testAuthentication() {
        CustomRealm customRealm = new CustomRealm();

        // 构建 SecurityManager
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(customRealm);

        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("md5");
        matcher.setHashIterations(1);

        customRealm.setCredentialsMatcher(matcher);

        // 主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("Mark", "123456");
        subject.login(token);

        // 是否认证
        System.out.println("isAuthenticated:" + subject.isAuthenticated());

        subject.checkRole("admin");
        subject.checkPermission("user:delete");
        subject.checkPermission("user:add");
    }
}
