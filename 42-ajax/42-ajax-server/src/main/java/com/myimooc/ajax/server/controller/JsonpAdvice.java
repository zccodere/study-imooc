//package com.myimooc.ajax.server.controller;
//
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;
//
///**
// * JSONP 全局处理；统一处理JSONP
// * <p>
// * 该类 AbstractJsonpResponseBodyAdvice 已被移除，建议用 @CrossOrigin 注解；Spring 5.0.8版本 源码注释如下
// *
// * @author zc 2018-04-18
// * @since 4.1
// * @deprecated Will be removed as of Spring Framework 5.1, use
// * <a href="https://docs.spring.io/spring/docs/5.0.x/spring-framework-reference/web.html#mvc-cors">CORS</a>
// * instead.
// * </p>
// */
//@ControllerAdvice
//public class JsonpAdvice extends AbstractJsonpResponseBodyAdvice {
//
//    public JsonpAdvice() {
//        // 与前端约定好回调方法名称，默认是callback
//        super("callback2");
//    }
//}
