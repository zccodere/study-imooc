package com.myimooc.java.sms.service;


import com.myimooc.java.sms.model.Student;

import java.util.List;

/**
 * 学生服务类
 *
 * @author zc
 * @date 2018/05/29
 */
public interface StudentService {

    /**
     * 获得多个学生
     *
     * @return 学生集合
     * @throws ServiceException 业务服务异常
     */
    List<Student> list() throws ServiceException;

    /**
     * 获得一个学生
     *
     * @param id ID
     * @return 学生
     * @throws ServiceException 业务服务异常
     */
    Student getOne(String id) throws ServiceException;

    /**
     * 创建学生信息
     *
     * @param student 学生信息
     * @throws ServiceException 业务服务异常
     */
    void createStudent(Student student) throws ServiceException;

    /**
     * 创建学生信息
     *
     * @param id    ID
     * @param name  名称
     * @param group 班级
     * @throws ServiceException 业务服务异常
     */
    void createStudent(String id, String name, String group) throws ServiceException;

    /**
     * 更新学生信息
     *
     * @param student 学生信息
     * @throws ServiceException 业务服务异常
     */
    void updateStudent(Student student) throws ServiceException;

    /**
     * 删除学生信息
     *
     * @param student 学生信息
     * @throws ServiceException 业务服务异常
     */
    void removeStudent(Student student) throws ServiceException;

}
