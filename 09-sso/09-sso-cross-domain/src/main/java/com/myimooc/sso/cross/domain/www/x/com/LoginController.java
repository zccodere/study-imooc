package com.myimooc.sso.cross.domain.www.x.com;

import com.myimooc.sso.cross.domain.util.RespMessage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * SSO登录控制器
 *
 * @author zc 2017-03-22
 */
@Controller
@RequestMapping("/sso")
public class LoginController {

    /**
     * 校验用户信息
     *
     * @return 响应对象
     */
    @GetMapping("/doLogin")
    @ResponseBody
    public RespMessage doLogin(String username, String password) {
        RespMessage result = new RespMessage();
        result.setRespCode("500");
        result.setRespMsg("用户名或密码错误");

        // 校验用户名和密码
        boolean ok = LoginCheck.checkLogin(username, password);
        // 判断是否登录成功
        if (ok) {
            result.setRespCode("200");
            result.setRespMsg("用户名和密码正确");

            List<Map<String, String>> targetCookies = new ArrayList<>(8);

            // 向www.a.com服务器发送增加cookie
            Map<String, String> targetCookieA = this.buildCookieMap("http://www.a.com/a/addCookie");

            // 向www.b.com服务器发送增加cookie
            Map<String, String> targetCookieB = this.buildCookieMap("http://www.b.com/b/addCookie");

            targetCookies.add(targetCookieA);
            targetCookies.add(targetCookieB);

            Map<String, Object> args = new HashMap<>(16);
            args.put("targetCookies", targetCookies);
            result.setRespArgs(args);
        }
        return result;
    }

    private Map<String, String> buildCookieMap(String targetUrl) {
        Map<String, String> map = new HashMap<>(16);
        map.put("targetUrl", targetUrl);
        map.put("cookieName", LoginCheck.COOKIE_NAME);
        map.put("cookieValue", LoginCheck.COOKIE_VALUE);
        return map;
    }

    /**
     * 校验cookie
     */
    @GetMapping("/checkCookie")
    @ResponseBody
    public RespMessage checkCookie(String cookieName, String cookieValue) {
        RespMessage result = new RespMessage();
        result.setRespCode("500");
        result.setRespMsg("CookieName或CookieValue无效");
        boolean isOk = LoginCheck.checkCookie(cookieName, cookieValue);
        if (isOk) {
            result.setRespCode("200");
            result.setRespMsg("Cookie有效");
        }
        return result;
    }
}
