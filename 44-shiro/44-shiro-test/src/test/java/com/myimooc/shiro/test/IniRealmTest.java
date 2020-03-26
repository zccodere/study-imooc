package com.myimooc.shiro.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * <br>
 * 标题: IniRealmTest测试类；讲解IniRealm
 *
 * @author zc 2018-05-02
 */
public class IniRealmTest {

    @Test
    public void testAuthentication() {

        // 使用IniRealm
        IniRealm iniRealm = new IniRealm("classpath:user.ini");

        // 构建 SecurityManager
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(iniRealm);

        // 主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("Mark", "123456");
        subject.login(token);

        // 是否认证
        System.out.println("isAuthenticated:" + subject.isAuthenticated());

        subject.checkRole("admin");
        subject.checkPermission("user:delete");
        subject.checkPermission("user:update");
    }

}
