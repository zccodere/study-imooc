package com.myimooc.hibernateaa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

/**
 * 学生实体类
 * @author ZhangCheng on 2017-07-12
 *
 */

@SuppressWarnings("unused")
@Entity
@Table(name="t_students",schema="hibernatemtm")
public class Students {
	
	/** 学号 */
	/* 方式一：使用自动生成主键
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer sid;
	*/
	
	/* 方式二：使用手工赋值方式生成主键
	@Id
	@GeneratedValue(generator="sid")
	@GenericGenerator(name="sid",strategy="assigned")//
	@Column(length=8)
	private String sid;
	*/
	
	/* 方式三：使用复合主键 */
	@EmbeddedId
	private StudentsPK pk;
	
	/** 姓名 */
	private String sname;
	/** 性别 */
	private String gender;
	/** 出生日期 */
	private Date birthday;
	/** 专业 */
	private String major;
	/** 薪水 */
	@Transient // 表示该属性不会被ORM映射到表里的字段
	private double salary;
	/** 地址 */
	@Embedded
	private Address address;
	
	@Override
	public String toString() {
		return "Students [pk=" + pk + ", sname=" + sname + ", gender=" + gender + ", birthday=" + birthday + ", major="
				+ major + ", salary=" + salary + ", address=" + address + "]";
	}
	
	public Students() {
		super();
	}
	
	public Students(StudentsPK pk, String sname, String gender, Date birthday, String major,Address address) {
		super();
		this.pk = pk;
		this.sname = sname;
		this.gender = gender;
		this.birthday = birthday;
		this.major = major;
		this.address = address;
	}
	
	public Students(StudentsPK pk, String sname, String gender, Date birthday, String major, double salary,
			Address address) {
		super();
		this.pk = pk;
		this.sname = sname;
		this.gender = gender;
		this.birthday = birthday;
		this.major = major;
		this.salary = salary;
		this.address = address;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	public StudentsPK getPk() {
		return pk;
	}

	public void setPk(StudentsPK pk) {
		this.pk = pk;
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
