package com.myimooc.spring.aop.proxy.chain;

/**
 * @author zc
 * @version 1.0 2017-09-13
 * @title 责任链模式
 * @describe 测试类
 */
public class Client {

    static class HandlerA extends AbstractHandler {
        @Override
        protected void handleProcess() {
            System.out.println("handle by a");
        }
    }

    static class HandlerB extends AbstractHandler {
        @Override
        protected void handleProcess() {
            System.out.println("handle by b");
        }
    }

    static class HandlerC extends AbstractHandler {
        @Override
        protected void handleProcess() {
            System.out.println("handle by c");
        }
    }

    public static void main(String[] args) {
        HandlerA handlerA = new HandlerA();
        HandlerB handlerB = new HandlerB();
        HandlerC handlerC = new HandlerC();
        // 设置链接关系
        handlerA.setSucessor(handlerB);
        handlerB.setSucessor(handlerC);

        handlerA.execute();
    }
}
