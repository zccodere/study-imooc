package com.myimooc.excel.boot.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 学生信息表
 * @author ZhangCheng on 2017-07-08
 *
 */
@Entity
@Table(name="student")
public class Student {
	
	@Id
	private Long id;
	private String stunum;
	private String stuname;
	private String stuage;
	private String stusex;
	private String stubirthday;
	private String stuhobby;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStunum() {
		return stunum;
	}
	public void setStunum(String stunum) {
		this.stunum = stunum;
	}
	public String getStuname() {
		return stuname;
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	public String getStuage() {
		return stuage;
	}
	public void setStuage(String stuage) {
		this.stuage = stuage;
	}
	public String getStusex() {
		return stusex;
	}
	public void setStusex(String stusex) {
		this.stusex = stusex;
	}
	public String getStubirthday() {
		return stubirthday;
	}
	public void setStubirthday(String stubirthday) {
		this.stubirthday = stubirthday;
	}
	public String getStuhobby() {
		return stuhobby;
	}
	public void setStuhobby(String stuhobby) {
		this.stuhobby = stuhobby;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", stunum=" + stunum + ", stuname=" + stuname + ", stuage=" + stuage + ", stusex="
				+ stusex + ", stubirthday=" + stubirthday + ", stuhobby=" + stuhobby + "]";
	}
}
