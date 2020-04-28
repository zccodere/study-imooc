package com.myimooc.hibernate.anno.ra.onetoonefk;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * 一对一单向外键关联； 学生实体类
 *
 * @author zc 2017-07-12
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
     * 身份证类
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pid", unique = true)
    private IdCard card;
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

    @Override
    public String toString() {
        return "Students [sid=" + sid + ", sname=" + ", gender=" + gender + ", birthday=" + birthday
                + ", major=" + major + "]";
    }

    public Students() {
    }

    public Students(IdCard card, String gender, Date birthday, String major) {
        super();
        this.card = card;
        this.gender = gender;
        this.birthday = birthday;
        this.major = major;
    }

    public Students(IdCard card, Integer sid, String gender, Date birthday, String major) {
        this.card = card;
        this.sid = sid;
        this.gender = gender;
        this.birthday = birthday;
        this.major = major;
    }

    public IdCard getCard() {
        return card;
    }

    public void setCard(IdCard card) {
        this.card = card;
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
