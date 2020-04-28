package com.myimooc.hibernate.anno.ra.manytoonefk;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 多对一单向外键关联； 学生实体类（多方）
 *
 * @author zc 2017-07-13
 */
@Entity
public class Students {

    /**
     * 学号
     */
    @Id
    @GeneratedValue
    private Integer sid;
    /**
     * 学生姓名
     */
    private String sname;
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
     * 多方持有一方的引用 // @ManyToOne(cascade={CascadeType.ALL},fetch=FetchType.EAGER)// 配置级联关系和抓取策略；
     * // @JoinColumn(name="cid",referencedColumnName="CID") // 指定外键
     */
    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "cid", referencedColumnName = "CID")
    private ClassRoom classRoom;

    @Override
    public String toString() {
        return "Students [sid=" + sid + ", sname=" + ", gender=" + gender + ", birthday=" + birthday
                + ", major=" + major + "]";
    }

    public Students() {
    }

    public Students(String sname, String gender, Date birthday, String major) {
        super();
        this.sname = sname;
        this.gender = gender;
        this.birthday = birthday;
        this.major = major;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
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
