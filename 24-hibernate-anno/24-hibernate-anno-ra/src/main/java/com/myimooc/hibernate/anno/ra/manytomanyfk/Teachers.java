package com.myimooc.hibernate.anno.ra.manytomanyfk;

import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 多对多单向外键关联； 教师实体类（多方）
 *
 * @author zc 2017-07-13
 */
@Entity
public class Teachers {

    /**
     * 教师编号
     */
    @Id
    @GeneratedValue(generator = "tid")
    @GenericGenerator(name = "tid", strategy = "assigned")
    @Column(length = 4)
    private String tid;
    /**
     * 教师姓名
     */
    private String tname;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Teachers teachers = (Teachers) o;
        return Objects.equals(tid, teachers.tid) &&
                Objects.equals(tname, teachers.tname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(tid, tname);
    }

    public Teachers(String tid, String tname) {
        this.tid = tid;
        this.tname = tname;
    }

    public Teachers() {
    }

    @Override
    public String toString() {
        return "Teachers [tid=" + tid + ", tname=" + tname + "]";
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }
}
