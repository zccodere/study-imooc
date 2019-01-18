package com.imooc.dao;

import com.imooc.domain.Student;

import java.util.List;

/**
 * StudentDAO访问接口
 */
public interface StudentDAO {

    /**
     * 查询所有学生
     * @return 所有学生
     */
    public List<Student> query();

    /**
     * 添加一个学生
     * @param student 待添加的学生
     */
    public void save(Student student);

}
