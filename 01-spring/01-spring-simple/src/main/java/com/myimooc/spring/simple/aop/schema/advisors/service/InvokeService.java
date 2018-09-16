package com.myimooc.spring.simple.aop.schema.advisors.service;

import org.springframework.dao.PessimisticLockingFailureException;
import org.springframework.stereotype.Service;

/**
 * <br>
 * 标题: 服务<br>
 * 描述: 服务<br>
 * 时间: 2017/01/18<br>
 *
 * @author zc
 */
@Service
public class InvokeService {

    public void invoke() {
        System.out.println("InvokeService ......");
    }

    public void invokeException() {
        throw new PessimisticLockingFailureException("");
    }

}
