package com.myimooc.spring.simple.beanannotation.jsr;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * 使用@Named
 *
 * @author zc 2017-01-18
 */
@Named
public class JsrService {

    /**
     * // @Resource // @Inject
     */
    private JsrDao jsrDao;

    @Inject
    public void setJsrDao(@Named("jsrDao") JsrDao jsrDao) {
        this.jsrDao = jsrDao;
    }

    @PostConstruct
    public void init() {
        System.out.println("JsrService init.");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("JsrService destroy.");
    }

    public void save() {
        jsrDao.save();
    }

}
