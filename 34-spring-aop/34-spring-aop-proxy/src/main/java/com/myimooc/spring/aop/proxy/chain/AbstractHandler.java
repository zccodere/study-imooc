package com.myimooc.spring.aop.proxy.chain;

/**
 * 责任链模式；抽象接口
 *
 * @author zc 2017-09-13
 */
public abstract class AbstractHandler {

    /**
     * 后继Handler，是否有类进行处理
     */
    private AbstractHandler process;

    /**
     * 对外暴露
     */
    public void execute() {
        handleProcess();
        if (process != null) {
            process.execute();
        }
    }

    /**
     * 由子类实现
     */
    protected abstract void handleProcess();

    public AbstractHandler getProcess() {
        return process;
    }

    public void setProcess(AbstractHandler process) {
        this.process = process;
    }

}
