package com.imooc.beanannotation.multibean;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.imooc.spring.beanannotation.multibean.BeanInterface;

@Order(1)
@Component
public class BeanImplTwo implements BeanInterface {

}
