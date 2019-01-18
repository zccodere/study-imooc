package com.myimooc.boot.dive.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <br>
 * 标题: 自定义Servlet<br>
 * 描述: 自定义Servlet<br>
 * 时间: 2018/10/10<br>
 *
 * @author zc
 */
@WebServlet(urlPatterns = "/my/servlet")
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("Hello,World");
    }
}
