package com.myimooc.hibernate.anno.aa.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * 学生主键类
 *
 * @author zc 2017-07-12
 */
@Embeddable
public class StudentsPk implements Serializable {

    /**
     * 省份证号码
     */
    @Column(length = 18)
    private String id;
    /**
     * 学号
     */
    @Column(length = 10)
    private String sid;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StudentsPk that = (StudentsPk) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(sid, that.sid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sid);
    }

    @Override
    public String toString() {
        return "StudentsPk{" +
                "id='" + id + '\'' +
                ", sid='" + sid + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }
}
