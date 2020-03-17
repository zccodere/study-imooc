package com.myimooc.hibernate.anno.ra.onetoonebfk;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * 一对一双向外键关联； 身份证实体类
 *
 * @author zc 2017-07-12
 */
@Entity
public class IdCard {

    @Id
    @GeneratedValue(generator = "pid")
    @GenericGenerator(name = "pid", strategy = "assigned")
    @Column(length = 18)
    /** 身份证号码 */
    private String pid;
    /**
     * 学生的姓名
     */
    private String sname;
    /**
     * 学生的引用
     */
    @OneToOne(mappedBy = "card")
    private Students stu;

    public Students getStu() {
        return stu;
    }

    public void setStu(Students stu) {
        this.stu = stu;
    }

    public IdCard() {
    }

    public IdCard(String pid, String sname) {
        this.pid = pid;
        this.sname = sname;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

}
