package com.myimooc.spring.simple.beanannotation.multiple;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 接口实现
 *
 * @author zc 2017-01-18
 */
@Order(2)
@Component
public class BeanImplOne implements BeanInterface {

}
