package com.myimooc.spring.data.jdbc.dao;


import com.myimooc.spring.data.jdbc.domain.Student;

import java.util.List;

/**
 * StudentDAO访问接口
 *
 * @author zc 2017-04-24
 */
public interface StudentDao {

    /**
     * 获取所有学生
     *
     * @return 所有学生
     */
    List<Student> listStudent();

    /**
     * 添加一个学生
     *
     * @param student 待添加的学生
     */
    void saveStudent(Student student);
}
