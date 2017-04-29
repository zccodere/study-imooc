package com.myimooc.springdata.jpa.service;

import com.myimooc.springdata.jpa.domain.Employee;
import com.myimooc.springdata.jpa.repository.EmployeeCrudRepository;
import com.myimooc.springdata.jpa.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by ZC on 2017/4/25.
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeCrudRepository employeeCrudRepository;

    @Transactional
    public void updateAgeById(Integer id, Integer age){
        this.employeeRepository.updateAgeById(id,age);
    };

    @Transactional
    public void save(List<Employee> employees){
        this.employeeCrudRepository.save(employees);
    }
}
