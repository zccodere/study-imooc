package com.myimooc.shiro.web.filter;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 自定义Filter；当存在指定角色中的某一个角色时，认证通过
 *
 * @author zc 2018-05-03
 */
public class RolesOrFilter extends AuthorizationFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        Subject subject = getSubject(request, response);
        String[] roles = (String[]) mappedValue;
        if (roles == null || roles.length == 0) {
            return true;
        }
        for (String role : roles) {
            if (subject.hasRole(role)) {
                return true;
            }
        }
        return false;
    }
}
