package com.myimooc.hibernate.mtm.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * 项目实体类
 *
 * @author zc 2017-07-11
 */
public class Project implements Serializable {

    /**
     * 项目编号
     */
    private Integer projectId;
    /**
     * 项目名称
     */
    private String projectName;
    /**
     * 添加一个员工的集合
     */
    private Set<Employee> employees;

    public Project() {
    }

    public Project(int projectId, String projectName) {
        this.projectId = projectId;
        this.projectName = projectName;
    }

    public Project(int projectId, String projectName, Set<Employee> employees) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Project project = (Project) o;
        return Objects.equals(projectId, project.projectId) &&
                Objects.equals(projectName, project.projectName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId, projectName);
    }

    @Override
    public String toString() {
        return "Project [projectId=" + projectId + ", projectName=" + projectName + ", employees=" + employees + "]";
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
