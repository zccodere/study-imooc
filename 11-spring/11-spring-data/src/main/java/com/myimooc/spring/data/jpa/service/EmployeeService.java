package com.myimooc.spring.data.jpa.service;

import com.myimooc.spring.data.jpa.domain.Employee;
import com.myimooc.spring.data.jpa.repository.EmployeeCrudRepository;
import com.myimooc.spring.data.jpa.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 雇员服务
 *
 * @author zc 2017-04-25
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeCrudRepository employeeCrudRepository;

    @Transactional(rollbackFor = Exception.class)
    public void updateAgeById(Integer id, Integer age) {
        this.employeeRepository.updateAgeById(id, age);
    }

    @Transactional(rollbackFor = Exception.class)
    public void save(List<Employee> employees) {
        this.employeeCrudRepository.saveAll(employees);
    }
}
