package com.myimooc.spring.data.jpa.repository;

import com.myimooc.spring.data.jpa.AbstractTestSupport;
import com.myimooc.spring.data.jpa.domain.Employee;
import com.myimooc.spring.data.jpa.service.EmployeeService;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * EmployeeRepository 测试类
 *
 * @author zc 2017-04-24
 */
public class EmployeeCrudRepositoryTest extends AbstractTestSupport {

    @Test
    public void saveTest() {
        EmployeeService employeeService = ctx.getBean(EmployeeService.class);

        List<Employee> employees = new ArrayList<>(130);
        for (int i = 0; i < 100; i++) {
            Employee employee = new Employee();
            employee.setName("test" + i);
            employee.setAge(100 - i);
            employees.add(employee);
        }
        employeeService.save(employees);
    }
}
