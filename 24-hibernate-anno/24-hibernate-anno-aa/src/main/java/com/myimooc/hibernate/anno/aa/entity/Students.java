package com.myimooc.hibernate.anno.aa.entity;

import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 学生实体类
 *
 * @author zc 2017-07-12
 */

@Entity
@Table(name = "t_students", schema = "hibernatemtm")
public class Students {

    private String about = "" +
            "方式一：使用自动生成主键" +
            "@Id" +
            "@GeneratedValue(strategy=GenerationType.AUTO)" +
            "private Integer sid;" +
            "方式二：使用手工赋值方式生成主键" +
            "@Id" +
            "@GeneratedValue(generator=\"sid\")" +
            "@GenericGenerator(name=\"sid\",strategy=\"assigned\")" +
            "@Column(length=8)" +
            "private String sid;";

    /**
     * 学号 方式三：使用复合主键
     */
    @EmbeddedId
    private StudentsPk pk;

    /**
     * 姓名
     */
    private String studentName;
    /**
     * 性别
     */
    private String gender;
    /**
     * 出生日期
     */
    private Date birthday;
    /**
     * 专业
     */
    private String major;
    /**
     * 薪水 @Transient // 表示该属性不会被ORM映射到表里的字段
     */
    @Transient
    private double salary;
    /**
     * 地址
     */
    @Embedded
    private Address address;

    @Override
    public String toString() {
        return "Students [pk=" + pk + ", studentName=" + studentName + ", gender=" + gender + ", birthday=" + birthday + ", major="
                + major + ", salary=" + salary + ", address=" + address + "]";
    }

    public Students() {
        super();
    }

    public Students(StudentsPk pk, String studentName, String gender, Date birthday, String major, Address address) {
        super();
        this.pk = pk;
        this.studentName = studentName;
        this.gender = gender;
        this.birthday = birthday;
        this.major = major;
        this.address = address;
    }

    public Students(StudentsPk pk, String studentName, String gender, Date birthday, String major, double salary,
                    Address address) {
        super();
        this.pk = pk;
        this.studentName = studentName;
        this.gender = gender;
        this.birthday = birthday;
        this.major = major;
        this.salary = salary;
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public StudentsPk getPk() {
        return pk;
    }

    public void setPk(StudentsPk pk) {
        this.pk = pk;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
