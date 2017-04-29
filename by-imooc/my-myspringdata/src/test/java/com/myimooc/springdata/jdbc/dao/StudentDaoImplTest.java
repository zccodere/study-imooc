package com.myimooc.springdata.jdbc.dao;

import com.myimooc.springdata.jdbc.dao.impl.StudentDaoImpl;
import com.myimooc.springdata.jdbc.domain.Student;
import org.junit.Test;

import java.util.List;

/**
 * Created by ZC on 2017/4/24.
 */
public class StudentDaoImplTest {

    @Test
    public void listStudentTest(){
        StudentDao studentDao = new StudentDaoImpl();

        List<Student>  studentList = studentDao.listStudent();
        for(Student student : studentList){
            System.out.println(student.toString());
        }
    }

    @Test
    public void saveStudentTest(){
        StudentDao studentDao = new StudentDaoImpl();

        Student student = new Student();
        student.setName("test");
        student.setAge(30);

        studentDao.saveStudent(student);
    }

}
