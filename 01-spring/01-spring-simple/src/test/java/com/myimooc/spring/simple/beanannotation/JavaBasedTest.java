package com.myimooc.spring.simple.beanannotation;


import com.myimooc.spring.simple.AbstractUnitTestSupport;
import com.myimooc.spring.simple.beanannotation.javabased.MyDriverManager;
import com.myimooc.spring.simple.beanannotation.javabased.Store;
import com.myimooc.spring.simple.beanannotation.javabased.StringStore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * <br>
 * 标题: 基于Java配置测试<br>
 * 描述: 基于Java配置测试<br>
 * 时间: 2017/01/18<br>
 *
 * @author zc
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class JavaBasedTest extends AbstractUnitTestSupport {
	
	public JavaBasedTest() {
		super("classpath*:spring-beanannotation.xml");
	}
	
	@SuppressWarnings("rawtypes")
    @Test
	public void test() {
		Store store = super.getBean("stringStore");
		System.out.println(store.getClass().getName());
	}
	
	@Test
	public void testMyDriverManager() {
		MyDriverManager manager = super.getBean("myDriverManager");
		System.out.println(manager.getClass().getName());
	}
	
	@SuppressWarnings("rawtypes")
    @Test
	public void testScope() {
		Store store = super.getBean("stringStore");
		System.out.println(store.hashCode());
		
		store = super.getBean("stringStore");
		System.out.println(store.hashCode());
	}
	
	@SuppressWarnings("unused")
    @Test
	public void testG() {
		StringStore store = super.getBean("stringStoreTest");
	}
	
}
