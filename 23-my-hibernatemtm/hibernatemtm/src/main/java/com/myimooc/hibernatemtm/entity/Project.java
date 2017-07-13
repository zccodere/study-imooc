package com.myimooc.hibernatemtm.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * project 实体类
 * @author ZhangCheng on 2017-07-11
 *
 */
public class Project implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int proid;
	
	private String proname;
	
	// 添加一个员工的集合
	private Set<Employee> employees = new HashSet<Employee>();

	public Project() {
	}

	public Project(int proid, String proname) {
		this.proid = proid;
		this.proname = proname;
	}

	public Project(int proid, String proname, Set<Employee> employees) {
		this.proid = proid;
		this.proname = proname;
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Project [proid=" + proid + ", proname=" + proname + ", employees=" + employees + "]";
	}

	public int getProid() {
		return proid;
	}

	public void setProid(int proid) {
		this.proid = proid;
	}

	public String getproname() {
		return proname;
	}

	public void setproname(String proname) {
		this.proname = proname;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
	
}
