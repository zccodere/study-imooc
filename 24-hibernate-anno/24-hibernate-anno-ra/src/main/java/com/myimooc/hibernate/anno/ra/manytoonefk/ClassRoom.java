package com.myimooc.hibernate.anno.ra.manytoonefk;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 多对一单向外键关联； 班级实体类（一方）
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

    public ClassRoom() {
    }

    public ClassRoom(String cid, String cname) {
        this.cid = cid;
        this.cname = cname;
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
