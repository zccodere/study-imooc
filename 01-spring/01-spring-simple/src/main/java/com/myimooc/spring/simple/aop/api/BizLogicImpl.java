package com.myimooc.spring.simple.aop.api;

/**
 * 业务逻辑实现
 *
 * @author zc 2017-01-18
 */
public class BizLogicImpl implements BizLogic {

    @Override
    public String save() {
        System.out.println("BizLogicImpl : BizLogicImpl save.");
        return "BizLogicImpl save.";
        // throw new RuntimeException();
    }

}
