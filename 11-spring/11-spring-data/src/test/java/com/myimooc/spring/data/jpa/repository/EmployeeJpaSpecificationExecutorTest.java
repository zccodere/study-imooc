package com.myimooc.spring.data.jpa.repository;

import com.myimooc.spring.data.jpa.config.SpringConfig;
import com.myimooc.spring.data.jpa.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

/**
 * EmployeeJpaSpecificationExecutor 单元测试类
 * Created by ZC on 2017/4/26.
 */
public class EmployeeJpaSpecificationExecutorTest {

    private ApplicationContext ctx = null;
    private EmployeeJpaSpecificationExecutor employeeJpaSpecificationExecutor = null;

    @Before
    public void init(){
        ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        employeeJpaSpecificationExecutor = ctx.getBean(EmployeeJpaSpecificationExecutor.class);
    }

    @After
    public void destroy(){
        ctx = null;
    }

    /**
     * 1、分页
     * 2、排序
     * 3、查询条件:age > 50
     */
    @Test
    public void queryTest(){
        Sort.Order order = new Sort.Order(Sort.Direction.DESC,"id");
        Sort sort = new Sort(order);
        // page: index是从0开始的，不是从1开始的
        Pageable pageable = new PageRequest(0,5,sort);

        /**
         * root : 就是我们要查询的类型 (Employee)
         * query : 添加查询条件
         * cb : 构建 Predicate
         */
        Specification<Employee> specification = new Specification<Employee>() {
            // 查询条件
            public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                // root (employee (age))
                Path path = root.get("age");
                return cb.gt(path,50);
            }
        };

        Page<Employee> employeePage = employeeJpaSpecificationExecutor.findAll(specification,pageable);

        System.out.println("查询的总页数："+employeePage.getTotalPages());
        System.out.println("查询的总记录数："+employeePage.getTotalElements());
        System.out.println("查询的当前第几页："+(employeePage.getNumber() + 1));
        System.out.println("查询的当前页面的集合："+employeePage.getContent());
        System.out.println("查询的当前页面的记录数："+employeePage.getNumberOfElements());

    }

}
