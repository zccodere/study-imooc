package com.myimooc.shiro.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.mysql.jdbc.Driver;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * <br>
 * 标题: JdbcRealmTest测试类<br>
 * 描述: 讲解JdbcRealm<br>
 *
 * @author zc
 * @date 2018/05/02
 */
public class JdbcRealmTest {

    private DruidDataSource dataSource = new DruidDataSource();

    {
        dataSource.setUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8&useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    }

    @Test
    public void  testAuthentication(){

        JdbcRealm jdbcRealm = new JdbcRealm();
        jdbcRealm.setDataSource(dataSource);
        // 启用到数据库查询权限数据（默认值：false）
        jdbcRealm.setPermissionsLookupEnabled(true);

        // 使用自定义SQL
        String sql = "select password from test_user where user_name = ?";
        jdbcRealm.setAuthenticationQuery(sql);

        String roleSql = "select role_name from test_user_role where user_name = ?";
        jdbcRealm.setUserRolesQuery(roleSql);

        // 构建 SecurityManager
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(jdbcRealm);

        // 主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

//        UsernamePasswordToken token = new UsernamePasswordToken("Mark","123456");
//        subject.login(token);
//        subject.checkRole("admin");
//        subject.checkRoles("admin","user");
//        subject.checkPermission("user:select");

        UsernamePasswordToken token = new UsernamePasswordToken("xiaoming","654321");
        subject.login(token);
        subject.checkRole("user");

        // 是否认证
        System.out.println("isAuthenticated:" + subject.isAuthenticated());
    }
}
