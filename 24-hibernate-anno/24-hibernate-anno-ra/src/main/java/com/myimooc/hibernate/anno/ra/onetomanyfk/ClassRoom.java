package com.myimooc.hibernate.anno.ra.onetomanyfk;

import org.hibernate.annotations.GenericGenerator;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 * 一对多单向外键关联； 班级实体类（一方）
 *
 * @author zc 2017-07-13
 */
@Entity
public class ClassRoom {

    /**
     * 班级编号
     */
    @Id
    @GeneratedValue(generator = "cid")
    @GenericGenerator(name = "cid", strategy = "assigned")
    @Column(length = 4)
    private String cid;
    /**
     * 班级名字
     */
    private String cname;

    /**
     * 一方持有多方的集合
     */
    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "cid")
    private Set<Students> stus;

    public ClassRoom() {
    }

    public ClassRoom(String cid, String cname) {
        this.cid = cid;
        this.cname = cname;
    }

    public Set<Students> getStus() {
        return stus;
    }

    public void setStus(Set<Students> stus) {
        this.stus = stus;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "ClassRoom [cid=" + cid + ", cname=" + cname + "]";
    }


}
