package com.myimooc.spring.data.jdbctemplate;

import com.myimooc.spring.data.jdbctemplate.config.SpringConfig;
import com.myimooc.spring.data.jdbctemplate.dao.StudentDao;
import com.myimooc.spring.data.jdbctemplate.domain.Student;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * 学生数据层测试类
 *
 * @author zc 2017-04-24
 */
public class StudentDaoTest {

    private ApplicationContext ctx = null;
    private StudentDao studentDao;

    @Before
    public void init() {
        ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        studentDao = ctx.getBean(StudentDao.class);
    }

    @After
    public void destroy() {
        ctx = null;
    }

    @Test
    public void listStudentTest() {
        List<Student> studentList = studentDao.listStudent();
        for (Student student : studentList) {
            System.out.println(student.toString());
        }
    }

    @Test
    public void saveTest() {
        Student student = new Student();
        student.setName("test-spring-jdbcTemplate");
        student.setAge(25);
        studentDao.saveStudent(student);
    }
}
