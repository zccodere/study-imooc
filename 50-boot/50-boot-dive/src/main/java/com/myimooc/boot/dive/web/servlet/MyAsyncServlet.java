package com.myimooc.boot.dive.web.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <br>
 * 标题: 自定义异步非阻塞Servlet<br>
 * 描述: 自定义异步非阻塞Servlet<br>
 * 时间: 2018/10/10<br>
 *
 * @author zc
 */
@WebServlet(urlPatterns = "/my/async/servlet", asyncSupported = true)
public class MyAsyncServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 获取异步上下文
        AsyncContext asyncContext = req.startAsync();

        asyncContext.start(() -> {
            try {
                resp.getWriter().println("Hello,World");

                // 触发完成
                asyncContext.complete();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
