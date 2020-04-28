package com.myimooc.hibernate.mtm.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * 员工实体类
 *
 * @author zc 2017-07-11
 */
public class Employee implements Serializable {

    /**
     * 员工编号
     */
    private Integer employeeId;
    /**
     * 员工姓名
     */
    private String employeeName;
    /**
     * 添加一个项目的集合
     */
    private Set<Project> projects;

    public Employee() {
    }

    public Employee(Integer employeeId, String employeeName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
    }

    public Employee(Integer employeeId, String employeeName, Set<Project> projects) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.projects = projects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return Objects.equals(employeeId, employee.employeeId) &&
                Objects.equals(employeeName, employee.employeeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, employeeName);
    }

    @Override
    public String toString() {
        return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", projects=" + projects + "]";
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

}
