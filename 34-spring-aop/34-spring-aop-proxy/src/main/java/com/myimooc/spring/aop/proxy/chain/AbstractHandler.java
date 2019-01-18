package com.myimooc.spring.aop.proxy.chain;

/**
 * @author zc
 * @version 1.0 2017-09-13
 * @title 责任链模式
 * @describe 抽象接口
 */
public abstract class AbstractHandler {

    /**
     * 后继Handler，是否有类进行处理
     */
    private AbstractHandler sucessor;

    /**
     * 对外暴露
     */
    public void execute() {
        handleProcess();
        if (sucessor != null) {
            sucessor.execute();
        }
    }

    /**
     * 由子类实现
     */
    protected abstract void handleProcess();

    public AbstractHandler getSucessor() {
        return sucessor;
    }

    public void setSucessor(AbstractHandler sucessor) {
        this.sucessor = sucessor;
    }

}
