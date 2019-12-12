package com.myimooc.spring.simple.beanannotation.multibean;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * <br>
 * 标题: 接口实现<br>
 * 描述: 接口实现<br>
 * 时间: 2017/01/18<br>
 *
 * @author zc
 */
@Order(1)
@Component
public class BeanImplTwo implements BeanInterface {

}
