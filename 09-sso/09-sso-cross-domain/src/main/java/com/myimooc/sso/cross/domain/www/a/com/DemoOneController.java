package com.myimooc.sso.cross.domain.www.a.com;

import com.myimooc.sso.cross.domain.util.HttpUtils;
import com.myimooc.sso.cross.domain.util.RespMessage;
import com.myimooc.sso.cross.domain.www.x.com.LoginCheck;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Demo1 控制层
 *
 * @author zc 2017-04-02
 */
@Controller
@RequestMapping("/a")
public class DemoOneController {

    /**
     * 跳转到demo1的主页
     *
     * @param request 请求对象
     * @return 响应视图
     */
    @RequestMapping("/demo1")
    public ModelAndView demo1(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();

        // 校验cookie是否为空
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            // 校验cookie是否存在
            for (Cookie cookie : cookies) {
                if (LoginCheck.COOKIE_NAME.equals(cookie.getName())) {
                    // 向校验服务器发送校验请求
                    String url = "http://www.x.com/sso/checkCookie";
                    RespMessage respMessage = LoginCheck.warpHttpGet(cookie.getName(), cookie.getValue(), url);
                    // 校验通过
                    if ("200".equals(respMessage.getRespCode())) {
                        mv.setViewName("demo1");
                        return mv;
                    }
                }
            }
        }
        // 登录失败重新登录
        String path = request.getContextPath();
        mv.addObject("contextPath", path);
        mv.addObject("path", "a");
        mv.addObject("gotoUrl", "http://www.a.com/a/demo1");
        mv.setViewName("login");
        return mv;
    }

    /**
     * 用户登录
     */
    @PostMapping(value = "/doLogin")
    @ResponseBody
    public RespMessage doLogin(@RequestParam Map<String, String> param) {
        // 向校验服务器发送校验请求
        String url = "http://www.x.com/sso/doLogin";
        RespMessage respMessage = HttpUtils.doGet(url, param);
        System.out.println("SSO服务器响应消息：" + respMessage);
        return respMessage;
    }

    /**
     * 想当前域添加cookie
     */
    @RequestMapping(value = "/addCookie")
    public void addCookie(String cookieName, String cookieValue, HttpServletResponse response) {
        Cookie cookie = new Cookie(cookieName, cookieValue);
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}
