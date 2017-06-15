package com.myimooc.springdata.jdbctemplate.dao;

import com.myimooc.springdata.jdbctemplate.domain.Student;

import java.util.List;

/**
 * StudentDAO访问接口
 * Created by ZC on 2017/4/24.
 */
public interface StudentDao {
    /**
     * 获取所有学生
     * @return 所有学生
     */
    List<Student> listStudent();

    /**
     * 添加一个学生
     * @param student 待添加的学生
     */
    void saveStudent(Student student);
}
