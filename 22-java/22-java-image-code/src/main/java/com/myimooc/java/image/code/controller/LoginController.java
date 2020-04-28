package com.myimooc.java.image.code.controller;

import com.myimooc.java.image.code.generator.Image;
import com.myimooc.java.image.code.generator.ImageResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录控制器
 *
 * @author zc 2017-07-09
 */
@Controller
public class LoginController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 登录主页
     */
    @RequestMapping("/login")
    public String identify(Model model, HttpServletRequest request, HttpServletResponse response) {
        try {
            ImageResult imageResult = Image.generateImage();
            model.addAttribute("file", imageResult.getName());
            model.addAttribute("tip", imageResult.getTip());
            System.out.println(imageResult.getName() + imageResult.getTip());
            Cookie cookie = new Cookie("note", imageResult.getUniqueKey());
            response.addCookie(cookie);
            request.getSession().setAttribute(imageResult.getUniqueKey(), imageResult);
        } catch (Exception ex) {
            logger.error("获取图片失败：", ex);
        }
        return "login";
    }

    /**
     * 刷新图片
     */
    @RequestMapping(value = "/getPng")
    @ResponseBody
    public String getPng(HttpServletRequest request) throws IOException {
        ImageResult imageResult = Image.generateImage();
        request.getSession().setAttribute("imageResult", imageResult);
        return imageResult.getName() + "," + imageResult.getTip();
    }

    /**
     * 验证消息
     */
    @PostMapping("/dologin")
    @ResponseBody
    public String doLogin(String location, HttpServletRequest request) {
        System.out.println("验证坐标：" + location);
        Cookie[] cookies = request.getCookies();
        Cookie note = null;
        String noteKey = "note";
        for (Cookie cookie : cookies) {
            if (noteKey.equals(cookie.getName())) {
                note = cookie;
                break;
            }
        }

        if (null == note) {
            return "ERROR";
        }

        ImageResult imageResult = (ImageResult) request.getSession().getAttribute(note.getValue());

        if (validate(location, imageResult)) {
            return "OK";
        }

        return "ERROR";
    }

    /**
     * 验证是否正确
     */
    private boolean validate(String locationString, ImageResult imageResult) {

        String[] resultArray = locationString.split(";");
        int[][] array = new int[resultArray.length][2];
        for (int i = 0; i < resultArray.length; i++) {
            String[] temp = resultArray[i].split(",");
            array[i][0] = Integer.parseInt(temp[0]) + 150 - 10;
            array[i][1] = Integer.parseInt(temp[1]) + 300;
        }

        for (int[] intArr : array) {
            int location = location(intArr[1], intArr[0]);
            System.out.println("解析后的坐标序号：" + location);
            if (!imageResult.getKeySet().contains(location)) {
                return false;
            }
        }

        return true;
    }

    private int location(int x, int y) {
        int y75 = 75;
        int y150 = 150;

        if (y >= 0 && y < y75) {
            return xLocation(x);
        } else if (y >= y75 && y <= y150) {
            return xLocation(x) + 4;
        } else {
            // 脏数据
            return -1;
        }
    }

    private int xLocation(int x) {
        int x75 = 75;
        int x150 = 150;
        int x225 = 225;
        int x300 = 300;
        if (x >= 0 && x < x75) {
            return 0;
        } else if (x >= x75 && x < x150) {
            return 1;
        } else if (x >= x150 && x < x225) {
            return 2;
        } else if (x >= x225 && x <= x300) {
            return 3;
        } else {
            // 脏数据
            return -1;
        }
    }
}
