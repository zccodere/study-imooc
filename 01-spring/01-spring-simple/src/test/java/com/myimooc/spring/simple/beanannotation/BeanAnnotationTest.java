package com.myimooc.spring.simple.beanannotation;

import com.myimooc.spring.simple.AbstractTestSupport;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * <br>
 * 标题: 使用@Component测试<br> 描述: 使用@Component测试<br> 时间: 2017/01/18<br>
 *
 * @author zc
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class BeanAnnotationTest extends AbstractTestSupport {

    public BeanAnnotationTest() {
        super("classpath*:spring-beanannotation.xml");
    }

    @Test
    public void testSay() {
        BeanAnnotation bean = super.getBean("beanAnnotation", BeanAnnotation.class);
        bean.say("This is test.");

        bean = super.getBean("beanAnnotation", BeanAnnotation.class);
        bean.say("This is test.");
    }

    @Test
    public void testScpoe() {
        BeanAnnotation bean = super.getBean("beanAnnotation", BeanAnnotation.class);
        bean.myHashCode();

        bean = super.getBean("beanAnnotation", BeanAnnotation.class);
        bean.myHashCode();
    }

}
