package com.myimooc.spring.simple.beanannotation;


import com.myimooc.spring.simple.AbstractTestSupport;
import com.myimooc.spring.simple.beanannotation.javabased.MyDriverManager;
import com.myimooc.spring.simple.beanannotation.javabased.Store;
import com.myimooc.spring.simple.beanannotation.javabased.StringStore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * 基于Java配置测试
 *
 * @author zc 2017-01-18
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class JavaBasedTest extends AbstractTestSupport {

    public JavaBasedTest() {
        super("spring-beanannotation.xml");
    }

    @Test
    public void test() {
        Store store = super.getBean("stringStore", Store.class);
        System.out.println(store.getClass().getName());
    }

    @Test
    public void testMyDriverManager() {
        MyDriverManager manager = super.getBean("myDriverManager", MyDriverManager.class);
        System.out.println(manager.getClass().getName());
    }

    @Test
    public void testScope() {
        Store store = super.getBean("stringStore", Store.class);
        System.out.println(store.hashCode());

        store = super.getBean("stringStore", Store.class);
        System.out.println(store.hashCode());
    }

    @Test
    public void testG() {
        StringStore store = super.getBean("stringStoreTest", StringStore.class);
        System.out.println(store);
    }

}
