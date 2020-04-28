package com.myimooc.sso.cross.domain.www.x.com;

import com.myimooc.sso.cross.domain.util.HttpUtils;
import com.myimooc.sso.cross.domain.util.RespMessage;

import java.util.HashMap;
import java.util.Map;

/**
 * 登录校验工具类
 *
 * @author zc 2017-03-22
 */
public class LoginCheck {

    /**
     * 测试用户名
     */
    private static final String USERNAME = "user";
    /**
     * 测试密码
     */
    private static final String PASSWORD = "123";
    /**
     * Cookie键
     */
    public static final String COOKIE_NAME = "sso_cookie";
    /**
     * Cookie值
     */
    static final String COOKIE_VALUE = "sso";

    /**
     * 登录用户名和密码校验
     *
     * @param username 用户名
     * @param password 密码
     * @return true已登录；false未登录
     */
    static boolean checkLogin(String username, String password) {
        return USERNAME.equalsIgnoreCase(username) && PASSWORD.equalsIgnoreCase(password);
    }

    /**
     * 校验Cookie
     */
    static boolean checkCookie(String cookieName, String cookieValue) {
        return COOKIE_NAME.equals(cookieName) && COOKIE_VALUE.equals(cookieValue);
    }

    public static RespMessage warpHttpGet(String cookieName, String cookieValue, String url) {
        // 封装请求参数
        Map<String, String> param = new HashMap<>(16);
        param.put("cookieName", cookieName);
        param.put("cookieValue", cookieValue);
        // 向校验服务器发送校验请求
        return HttpUtils.doGet(url, param);
    }
}
