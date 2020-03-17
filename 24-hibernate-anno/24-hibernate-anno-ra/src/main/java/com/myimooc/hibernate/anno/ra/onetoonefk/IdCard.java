package com.myimooc.hibernate.anno.ra.onetoonefk;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 一对一单向外键关联； 身份证实体类
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
