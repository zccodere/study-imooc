package com.imooc.spring.beanannotation.multibean;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.imooc.beanannotation.multibean.BeanInterface;

@Order(2)
@Component
public class BeanImplOne implements BeanInterface {

}
