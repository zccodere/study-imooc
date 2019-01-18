package com.myimooc.spring.mvc.simple.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Web项目启动类
 * @author zhangcheng
 * @version v1.0 2017-02-17
 *
 */
public class WebInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        
        context.register(SpringMvcConfig.class);
        
        //新建WebApplication，注册配置类，并将其和当前servletContext关联。
        context.setServletContext(servletContext);
        
        // 注册SpringMvc的DispatcherServlet。
        Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
    }

}
