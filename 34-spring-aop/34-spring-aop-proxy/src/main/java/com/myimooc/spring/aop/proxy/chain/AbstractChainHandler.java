package com.myimooc.spring.aop.proxy.chain;

/**
 * 责任链模式；对Handler进行封装
 *
 * @author zc 2017-09-13
 */
public abstract class AbstractChainHandler {

    public void execute(Chain chain) {
        handleProcess();
        chain.proceed();
    }

    /**
     * 由子类实现
     */
    protected abstract void handleProcess();

}
