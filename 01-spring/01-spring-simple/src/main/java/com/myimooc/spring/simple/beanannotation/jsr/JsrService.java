package com.myimooc.spring.simple.beanannotation.jsr;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * <br>
 * 标题: 使用@Named<br>
 * 描述: 使用@Named<br>
 * 时间: 2017/01/18<br>
 *
 * @author zc
 */
@Named
public class JsrService {

    /**
     * // @Resource
     * // @Inject
     */
    private JsrDAO jsrDAO;

    @Inject
    public void setJsrDAO(@Named("jsrDAO") JsrDAO jsrDAO) {
        this.jsrDAO = jsrDAO;
    }

    @PostConstruct
    public void init() {
        System.out.println("JsrServie init.");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("JsrServie destroy.");
    }

    public void save() {
        jsrDAO.save();
    }

}
