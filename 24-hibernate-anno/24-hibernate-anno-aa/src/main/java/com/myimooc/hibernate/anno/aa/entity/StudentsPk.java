package com.myimooc.hibernate.anno.aa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * 学生主键类
 *
 * @author ZhangCheng on 2017-07-12
 */
@Embeddable
public class StudentsPk implements Serializable {

    private static final long serialVersionUID = 1L;

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

    public StudentsPk() {
    }

    @Override
    public String toString() {
        return "StudentsPk [id=" + id + ", sid=" + sid + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((sid == null) ? 0 : sid.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        StudentsPk other = (StudentsPk) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (sid == null) {
            if (other.sid != null) {
                return false;
            }
        } else if (!sid.equals(other.sid)) {
            return false;
        }
        return true;
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
