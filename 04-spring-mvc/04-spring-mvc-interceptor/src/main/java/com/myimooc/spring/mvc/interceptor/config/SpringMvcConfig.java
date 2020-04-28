package com.myimooc.spring.mvc.interceptor.config;

import com.myimooc.spring.mvc.interceptor.web.interceptor.Test1Interceptor;
import com.myimooc.spring.mvc.interceptor.web.interceptor.Test2Interceptor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

/**
 * Web项目SpringMvc配置
 *
 * @author zc 2017-02-17
 */
@EnableWebMvc
@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {

    /**
     * 配置 thymeleaf 模版解析器
     *
     * @return 视图解析器
     */
    @Bean
    public SpringResourceTemplateResolver templateResolver(ApplicationContext applicationContext) {
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setApplicationContext(applicationContext);
        resolver.setPrefix("classpath:/templates/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode(TemplateMode.HTML);
        resolver.setCacheable(false);
        resolver.setCharacterEncoding("UTF-8");
        return resolver;
    }

    /**
     * 配置SpringMvc视图解析器
     *
     * @return 视图解析器
     */
    @Bean
    public ViewResolver viewResolver(SpringResourceTemplateResolver templateResolver) {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);

        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine);
        resolver.setCharacterEncoding("UTF-8");
        return resolver;
    }

    /**
     * 配置静态资源映射
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    /**
     * 配置SpringMvc文件上传解析器
     *
     * @return 文件上传解析器
     */
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        // 设置文件上传大小，最大200M
        multipartResolver.setMaxUploadSize(209715200);
        multipartResolver.setDefaultEncoding("UTF-8");
        multipartResolver.setResolveLazily(true);
        return multipartResolver;
    }

    /**
     * 配置自定义的拦截器的Bean
     *
     * @return 自定义的拦截器
     */
    @Bean
    public Test1Interceptor test1Interceptor() {
        return new Test1Interceptor();
    }

    /**
     * 配置自定义的拦截器的Bean
     *
     * @return 自定义的拦截器
     */
    @Bean
    public Test2Interceptor test2Interceptor() {
        return new Test2Interceptor();
    }

    /**
     * 重写addInterceptors方法，注册拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        InterceptorRegistration interceptorRegistration = registry.addInterceptor(test1Interceptor());
//        interceptorRegistration.addPathPatterns("/view/all");
//        registry.addInterceptor(test1Interceptor());
//        registry.addInterceptor(test2Interceptor());
    }
}
