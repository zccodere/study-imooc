package com.myimooc.spring.aop.proxy.chain;

import java.util.Arrays;
import java.util.List;

/**
 * 责任链模式；有顺序的链式调用测试类
 *
 * @author zc 2017-09-13
 */
public class ChainClient {

    static class ChainHandlerA extends AbstractChainHandler {
        @Override
        protected void handleProcess() {
            System.out.println("handle by a");
        }
    }

    static class ChainHandlerB extends AbstractChainHandler {
        @Override
        protected void handleProcess() {
            System.out.println("handle by b");
        }
    }

    static class ChainHandlerC extends AbstractChainHandler {
        @Override
        protected void handleProcess() {
            System.out.println("handle by c");
        }
    }

    public static void main(String[] args) {
        // 声明链式调用顺序
        List<AbstractChainHandler> handlers = Arrays.asList(
                new ChainHandlerA(),
                new ChainHandlerB(),
                new ChainHandlerC()
        );

        Chain chain = new Chain(handlers);
        chain.proceed();
    }
}
