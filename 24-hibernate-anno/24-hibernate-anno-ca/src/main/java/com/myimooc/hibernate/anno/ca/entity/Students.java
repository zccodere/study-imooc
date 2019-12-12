package com.myimooc.hibernate.anno.ca.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 学生实体类
 * @author ZhangCheng on 2017-07-12
 *
 */
//JPA注解
//@Entity(name="t_students")

@Entity
@Table(name="t_students",schema="hibernatemtm")
public class Students {
	
	/** 学号 */
	@Id
	private Integer sid;
	/** 姓名 */
	private String sname;
	/** 性别 */
	private String gender;
	/** 出生日期 */
	private Date birthday;
	/** 专业 */
	private String major;
	/** 地址 */
	private Address address;
	
	@Override
	public String toString() {
		return "Students [sid=" + sid + ", sname=" + sname + ", gender=" + gender + ", birthday=" + birthday
				+ ", major=" + major + "]";
	}
	
	public Students() {
		super();
	}
	public Students(Integer sid, String sname, String gender, Date birthday, String major,Address address) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.gender = gender;
		this.birthday = birthday;
		this.major = major;
		this.address = address;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
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
