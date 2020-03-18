package com.myimooc.small.advanced.domain;

import java.io.Serializable;

/**
 * 获取 access_token 微信接口响应对象
 *
 * @author zc 2017-08-12
 */
public class AccessToken implements Serializable {

    private static final long serialVersionUID = 1L;

    private String token;

    private int expiresIn;

    @Override
    public String toString() {
        return "AccessToken [token=" + token + ", expiresIn=" + expiresIn + "]";
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }
}
