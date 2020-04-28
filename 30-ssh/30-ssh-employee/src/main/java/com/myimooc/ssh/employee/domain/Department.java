package com.myimooc.ssh.employee.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 * 部门实体对象
 *
 * @author zc 2017-08-17
 */
@Entity
public class Department {

    @Id
    @GeneratedValue
    private Integer did;

    private String dname;

    private String ddesc;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "eid")
    private Set<Employee> employees = new HashSet<Employee>();

    @Override
    public String toString() {
        return "Department [did=" + did + ", dname=" + dname + ", ddesc=" + ddesc + ", employees=" + String.valueOf(employees) + "]";
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDdesc() {
        return ddesc;
    }

    public void setDdesc(String ddesc) {
        this.ddesc = ddesc;
    }


}
