package com.myimooc.sso.same.father.util;

/**
 * 登录校验工具类
 * 
 * @author ZhangCheng
 * @date 2017-03-22
 * @version V1.0
 */
public class LoginCheck {
    /** 测试用户名 */
    public static final String USERNAME = "user";
    /** 测试密码 */
    public static final String PASSWORD = "123";
    /** Cookie键 */
    public static final String COOKIE_NAME = "ssocookie";
    /** Cookie值 */
    public static final String COOKIE_VALUE = "sso";
    
    /**
     * 登录用户名和密码校验
     * 
     * @param username
     *            用户名
     * @param password
     *            密码
     * @return true已登录；false未登录
     */
    public static boolean checkLogin(String username, String password) {
        if (USERNAME.equalsIgnoreCase(username) && PASSWORD.equalsIgnoreCase(password)) {
            return true;
        }
        return false;
    }

    /**
     * 校验Cookie
     * @param cookieName
     * @param cookieValue
     * @return
     */
    public static boolean checkCookie(String cookieName,String cookieValue) {
        if (cookieName == null || cookieName=="") {
            return false;
        }
        if (cookieValue == null || cookieValue=="") {
            return false;
        }
        if (COOKIE_NAME.equals(cookieName) && COOKIE_VALUE.equals(cookieValue)) {
            return true;
        }
        return false;
    }

}
