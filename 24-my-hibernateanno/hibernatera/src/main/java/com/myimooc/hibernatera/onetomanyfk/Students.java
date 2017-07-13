package com.myimooc.hibernatera.onetomanyfk;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 一对多单向外键关联
 * 学生实体类（多方）
 * @author ZhangCheng on 2017-07-13
 *
 */
@Entity
public class Students {
	
	/** 学号 */
	@Id
	@GeneratedValue
	private Integer sid;
	/** 学生姓名 */
	private String sname;
	/** 性别 */
	private String gender;
	/** 出生日期 */
	private Date birthday;
	/** 专业 */
	private String major;

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
