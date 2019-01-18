package com.myimooc.spring.mvc.bind.config;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Web项目启动类
 * 
 * @author zhangcheng
 * @version v1.0 2017-02-19
 *
 */
public class WebInitConfig implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();

        // 注册SpringMVC的配置类
        context.register(SpringMvcConfig.class);

        // 新建WebApplication，注册配置类，并将其和当前servletContext关联。
        context.setServletContext(servletContext);

        // 注册SpringMVC的DispatcherServlet。
        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);

        // 注册SpringMVC的字符过滤器
        FilterRegistration.Dynamic encodingFilter = servletContext.addFilter("encoding", new CharacterEncodingFilter());
        EnumSet<DispatcherType> dispatcherTypes = EnumSet.allOf(DispatcherType.class);
        dispatcherTypes.add(DispatcherType.REQUEST);
        dispatcherTypes.add(DispatcherType.FORWARD);
        encodingFilter.addMappingForUrlPatterns(dispatcherTypes, true, "*");
        encodingFilter.setInitParameter("encoding", "UTF-8");
        

    }

}
