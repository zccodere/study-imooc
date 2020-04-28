package com.myimooc.shiro.web.vo;

import java.io.Serializable;

/**
 * 用户实体类；
 *
 * @author zc 2018-05-02
 */
public class User implements Serializable {

    private static final long serialVersionUID = -4486078810058797882L;

    private String username;

    private String password;

    private Boolean rememberMe;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", rememberMe='" + rememberMe + '\'' +
                '}';
    }

    public Boolean getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(Boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
