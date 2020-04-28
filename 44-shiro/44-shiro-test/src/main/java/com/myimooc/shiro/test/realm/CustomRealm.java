package com.myimooc.shiro.test.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 自定义Realm；Realm讲解
 *
 * @author zc 2018-05-02
 */
public class CustomRealm extends AuthorizingRealm {

    private Map<String, String> userMap = new HashMap<>(16);

    {
        userMap.put("Mark", "283538989cef48f3d7d8a1c1bdf2008f");
        super.setName("customRealm");
    }

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String userName = (String) principals.getPrimaryPrincipal();
        // 通过用户名获取角色数据
        Set<String> roles = getRolesByUserName(userName);
        // 通过用户名获取权限数据
        Set<String> permissions = getPermissionsByUserName(userName);
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(roles);
        authorizationInfo.setStringPermissions(permissions);
        return authorizationInfo;
    }

    /**
     * 模拟从数据库或缓存中获取权限数据
     *
     * @param userName 用户名
     * @return 权限数据
     */
    private Set<String> getPermissionsByUserName(String userName) {
        Set<String> permissions = new HashSet<>(16);
        permissions.add("user:delete");
        permissions.add("user:add");
        return permissions;
    }

    /**
     * 模拟从数据库或缓存中获取角色数据
     *
     * @param userName 用户名
     * @return 角色数据
     */
    private Set<String> getRolesByUserName(String userName) {
        Set<String> roles = new HashSet<>(16);
        roles.add("admin");
        roles.add("user");
        return roles;
    }

    /**
     * 认证
     *
     * @param token 主体传送过来的认证信息
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 获取用户名
        String userName = (String) token.getPrincipal();
        // 通过用户名到数据库中获取凭证
        String password = getPasswordByUserName(userName);
        if (password == null) {
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo("Mark", password, "customRealm");
        authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes("Mark"));
        return authenticationInfo;
    }

    /**
     * 模拟数据库查询凭证
     *
     * @param userName 用户名
     * @return 凭证
     */
    private String getPasswordByUserName(String userName) {
        // 实际开发中需访问数据库
        return userMap.get(userName);
    }

    public static void main(String[] args) {
        Md5Hash md5Hash = new Md5Hash("123456", "Mark");
        System.out.println(md5Hash.toString());
    }

}
