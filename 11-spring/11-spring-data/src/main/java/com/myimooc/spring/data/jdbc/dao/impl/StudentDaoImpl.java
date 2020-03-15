package com.myimooc.spring.data.jdbc.dao.impl;

import com.myimooc.spring.data.jdbc.dao.StudentDao;
import com.myimooc.spring.data.jdbc.domain.Student;
import com.myimooc.spring.data.jdbc.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * StudentDAO访问接口实现类：通过最原始的JDBC的方式操作
 *
 * @author zc 2017-04-24
 */
public class StudentDaoImpl implements StudentDao {

    @Override
    public List<Student> listStudent() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select id,name,age from test_student";
        try {
            connection = JdbcUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            List<Student> studentList = new ArrayList<>();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Integer age = resultSet.getInt("age");

                Student student = new Student();
                student.setId(id);
                student.setName(name);
                student.setAge(age);

                studentList.add(student);
            }
            return studentList;
        } catch (Exception ex) {
            throw new RuntimeException("查询学生列表异常：", ex);
        } finally {
            JdbcUtils.release(resultSet, preparedStatement, connection);
        }
    }

    @Override
    public void saveStudent(Student student) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "insert into test_student(name,age) values(?,?)";
        try {
            connection = JdbcUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException("保存学生异常：", ex);
        } finally {
            JdbcUtils.release(null, preparedStatement, connection);
        }
    }
}
