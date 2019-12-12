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
 * <br>
 * 标题: StudentDAO访问接口实现类：通过最原始的JDBC的方式操作<br>
 * 描述: StudentDAO访问接口实现类：通过最原始的JDBC的方式操作<br>
 * 时间: 2017/04/24<br>
 *
 * @author zc
 */
public class StudentDaoImpl implements StudentDao {

    @Override
    public List<Student> listStudent() {
        List<Student> studentList = new ArrayList<Student>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select id,name,age from student";
        try {
            connection = JdbcUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

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
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(resultSet, preparedStatement, connection);
        }
        return studentList;
    }

    @Override
    public void saveStudent(Student student) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "insert into student(name,age) values(?,?)";
        try {
            connection = JdbcUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getAge());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(resultSet, preparedStatement, connection);
        }
    }
}
