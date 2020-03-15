package com.myimooc.spring.data.jpa.repository;

import com.myimooc.spring.data.jpa.AbstractTestSupport;
import com.myimooc.spring.data.jpa.domain.Employee;

import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

/**
 * EmployeeJpaSpecificationExecutor 测试类
 *
 * @author zc 2017-04-26
 */
public class EmployeeJpaSpecificationExecutorTest extends AbstractTestSupport {

    /**
     * 1、分页 2、排序 3、查询条件:age > 50
     */
    @Test
    public void queryTest() {
        EmployeeJpaSpecificationExecutor executor = ctx.getBean(EmployeeJpaSpecificationExecutor.class);

        // 根据ID降序排序
        Sort sort = Sort.by("id").descending();

        // page: index是从0开始的，不是从1开始的
        Pageable pageable = PageRequest.of(0, 5, sort);

        // 查询条件：root 就是我们要查询的类型 (Employee)；query 添加查询条件；cb 构建 Predicate
        Specification<Employee> specification = (Specification<Employee>) (root, query, cb) -> cb.gt(root.get("age"), 50);

        Page<Employee> employeePage = executor.findAll(specification, pageable);

        System.out.println("查询的总页数：" + employeePage.getTotalPages());
        System.out.println("查询的总记录数：" + employeePage.getTotalElements());
        System.out.println("查询的当前第几页：" + (employeePage.getNumber() + 1));
        System.out.println("查询的当前页面的集合：" + employeePage.getContent());
        System.out.println("查询的当前页面的记录数：" + employeePage.getNumberOfElements());
    }
}
