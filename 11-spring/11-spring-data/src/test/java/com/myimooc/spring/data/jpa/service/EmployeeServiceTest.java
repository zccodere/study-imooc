package com.myimooc.spring.data.jpa.service;

import com.myimooc.spring.data.jpa.AbstractTestSupport;

import org.junit.Test;

/**
 * EmployeeService 测试类
 *
 * @author zc 2017-04-25
 */
public class EmployeeServiceTest extends AbstractTestSupport {

    @Test
    public void updateAgeByIdTest() {
        EmployeeService employeeService = ctx.getBean(EmployeeService.class);
        // 更新操作
        employeeService.updateAgeById(1, 55);
    }
}
