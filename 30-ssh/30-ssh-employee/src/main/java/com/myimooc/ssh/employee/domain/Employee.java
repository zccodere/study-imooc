package com.myimooc.ssh.employee.domain;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 员工实体对象
 *
 * @author zc 2017-08-17
 */
@Entity
public class Employee {

    /**
     * id
     */
    @Id
    @GeneratedValue
    private Integer eid;
    /**
     * 姓名
     */
    private String ename;
    /**
     * 性别
     */
    private String sex;
    /**
     * 出生日期
     */
    private Date birthday;
    /**
     * 入职时间
     */
    private Date joinDate;
    /**
     * 编号
     */
    private String eno;
    /**
     * 登录名
     */
    private String username;
    /**
     * 登录密码
     */
    private String password;
    /**
     * 所属部门 // 配置级联关系和抓取策略
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "did")
    private Department department;

    @Override
    public String toString() {
        return "Employee [eid=" + eid + ", ename=" + ename + ", sex=" + sex + ", birthday=" + birthday + ", joinDate="
                + joinDate + ", eno=" + eno + ", username=" + username + ", password=" + password + ", department="
                + String.valueOf(department) + "]";
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
        return Objects.equals(eid, employee.eid) &&
                Objects.equals(ename, employee.ename) &&
                Objects.equals(sex, employee.sex) &&
                Objects.equals(eno, employee.eno);
    }

    @Override
    public int hashCode() {

        return Objects.hash(eid, ename, sex, eno);
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public String getEno() {
        return eno;
    }

    public void setEno(String eno) {
        this.eno = eno;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
