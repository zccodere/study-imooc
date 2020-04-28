package com.myimooc.small.auth.wxauth.rest;

import com.alibaba.fastjson.JSONObject;
import com.myimooc.small.auth.wxauth.domain.User;
import com.myimooc.small.auth.wxauth.repository.UserRepository;
import com.myimooc.small.auth.wxauth.util.AuthUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sun.security.action.GetPropertyAction;

import java.net.URLEncoder;
import java.security.AccessController;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录认证REST
 *
 * @author zc 2017-08-12
 */
@Controller
public class LoginRest {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = {"/", "", "/index"})
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    /**
     * 第一步：用户同意授权，获取code 入口地址
     */
    @RequestMapping("wxlogin")
    public Object doLogin(HttpServletRequest req) throws Exception {
        // 编码名称
        String enc = AccessController.doPrivileged(new GetPropertyAction("file.encoding"));
        // 用户授权后微信回调地址
        String backUrl = "/callback";
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + AuthUtils.APPID
                + "&redirect_uri=" + URLEncoder.encode(backUrl, enc)
                + "&response_type=code"
                + "&scope=snsapi_userinfo "
                + "&state=STATE#wechat_redirect";

        return "redirect:" + url;
    }

    /**
     * 第二步：通过code换取网页授权access_token 回调地址-得到code，从而去获得access_token 和 openid
     */
    @RequestMapping("/callback")
    public ModelAndView doCallBack(HttpServletRequest req) throws Exception {
        String code = req.getParameter("code");
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + AuthUtils.APPID
                + "&secret=" + AuthUtils.APPSECRET
                + "&code=" + code
                + "&grant_type=authorization_code";
        JSONObject jsonObject = AuthUtils.doGetJson(url);
        String openid = jsonObject.getString("openid");
        String accessToken = jsonObject.getString("access_token");
        // 第三步：刷新access_token（如果需要）
        // 此处省略

        // 第四步：拉取用户信息(需scope为 snsapi_userinfo)
        String infoUrl = "https://api.weixin.qq.com/sns/userinfo?access_token=" + accessToken
                + "&openid=" + openid
                + "&lang=zh_CN";
        JSONObject userInfo = AuthUtils.doGetJson(infoUrl);
        System.out.println("用户信息：" + userInfo);
        ModelAndView mv = new ModelAndView("success");
        mv.addObject("info", userInfo);
        String unionid = userInfo.getString("unionid");

        // 1.使用微信用户信息直接登录，无须注册和绑定，直接跳转到登录成功界面
        boolean isNeedBind = false;
        if (isNeedBind) {
            mv.addObject("info", userInfo);
            return mv;
        }

        // 2.将微信与当前系统的账号进行绑定，绑定后跳转到登录成功界面
        User user = userRepository.findByUnionid(unionid);
        if (null != user && (!Objects.equals("", user.getNickname()))) {
            // 已绑定，直接跳转绑定成功的页面
            mv.setViewName("bindsuccess");
            mv.addObject("nickname", user.getNickname());
            return mv;
        } else {
            // 未绑定，跳转到自己系统的登录页面
            mv.setViewName("login");
            mv.addObject("unionid", unionid);
            return mv;
        }
    }

    /**
     * 登录并绑定微信账号
     */
    @PostMapping("/bindwx")
    public Object bindwx(User user) {
        userRepository.save(user);
        return "账号绑定成功";
    }
}
