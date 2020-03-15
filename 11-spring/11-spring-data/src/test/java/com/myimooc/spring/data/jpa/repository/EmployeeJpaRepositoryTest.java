package com.myimooc.spring.data.jpa.repository;

import com.myimooc.spring.data.jpa.AbstractTestSupport;
import com.myimooc.spring.data.jpa.domain.Employee;

import org.junit.Test;

/**
 * PagingAndSortingRepository 测试类
 *
 * @author zc 2017-04-26
 */
public class EmployeeJpaRepositoryTest extends AbstractTestSupport {

    @Test
    public void findTest() {
        EmployeeJpaRepository repository = super.ctx.getBean(EmployeeJpaRepository.class);

        Employee employee = repository.findById(99).orElse(new Employee());
        System.out.println("employee" + employee.toString());

        System.out.println("employee(10)" + repository.existsById(10));
        System.out.println("employee(102)" + repository.existsById(102));
    }
}
