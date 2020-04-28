package com.myimooc.spring.data.jdbc;

import com.myimooc.spring.data.jdbc.dao.StudentDao;
import com.myimooc.spring.data.jdbc.dao.impl.StudentDaoImpl;
import com.myimooc.spring.data.jdbc.domain.Student;

import org.junit.Test;

import java.util.List;

/**
 * 学生数据层测试类
 *
 * @author zc 2017-04-24
 */
public class StudentDaoTest {

    @Test
    public void listStudentTest() {
        StudentDao studentDao = new StudentDaoImpl();
        List<Student> studentList = studentDao.listStudent();
        for (Student student : studentList) {
            System.out.println(student.toString());
        }
    }

    @Test
    public void saveStudentTest() {
        StudentDao studentDao = new StudentDaoImpl();
        Student student = new Student();
        student.setName("test");
        student.setAge(30);
        studentDao.saveStudent(student);
    }
}
