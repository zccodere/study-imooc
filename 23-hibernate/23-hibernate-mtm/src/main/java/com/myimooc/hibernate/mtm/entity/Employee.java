package com.myimooc.hibernate.mtm.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * employee 实体类
 *
 * @author ZhangCheng on 2017-07-11
 */
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    private int empid;

    private String empname;

    /**
     * 添加一个项目的集合
     */
    private Set<Project> projects = new HashSet<Project>();

    public Employee() {
    }

    public Employee(int empid, String empname) {
        this.empid = empid;
        this.empname = empname;
    }

    public Employee(int empid, String empname, Set<Project> projects) {
        this.empid = empid;
        this.empname = empname;
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
        return empid == employee.empid &&
                Objects.equals(empname, employee.empname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(empid, empname);
    }

    @Override
    public String toString() {
        return "Employee [empid=" + empid + ", empname=" + empname + ", projects=" + projects + "]";
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

}
