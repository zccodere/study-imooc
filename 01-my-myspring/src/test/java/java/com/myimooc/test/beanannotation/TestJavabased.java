package java.com.myimooc.test.beanannotation;

import java.com.myimooc.test.base.UnitTestBase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.myimooc.spring.beanannotation.javabased.MyDriverManager;
import com.myimooc.spring.beanannotation.javabased.Store;
import com.myimooc.spring.beanannotation.javabased.StringStore;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestJavabased extends UnitTestBase {
	
	public TestJavabased() {
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
