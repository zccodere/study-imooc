package com.myimooc.spring.data.jpa.repository;

import com.myimooc.spring.data.jpa.config.SpringConfig;
import com.myimooc.spring.data.jpa.domain.Employee;
import com.myimooc.spring.data.jpa.service.EmployeeService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import java.util.ArrayList;
import java.util.List;

/**
 * EmployeeRepository单元测试类
 * Created by ZC on 2017/4/24.
 */
public class EmployeeCrudRepositoryTest {

    private ApplicationContext ctx = null;
    private EmployeeService employeeService = null;

    @Before
    public void init(){
        ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        employeeService = ctx.getBean(EmployeeService.class);
    }

    @After
    public void destroy(){
        ctx = null;
    }

    @Test
    public void entityManageFactoryTest(){
        LocalContainerEntityManagerFactoryBean entityManagerFactory = (LocalContainerEntityManagerFactoryBean)ctx.getBean(LocalContainerEntityManagerFactoryBean.class);
        Assert.assertNotNull(entityManagerFactory);
    }

    @Test
    public void saveTest(){
        List<Employee> employees = new ArrayList<Employee>();
        Employee employee = null;
        for(int i=0;i<100;i++){
            employee = new Employee();
            employee.setName("test"+i);
            employee.setAge(100 - i);
            employees.add(employee);
        }
        employeeService.save(employees);
    }

}
