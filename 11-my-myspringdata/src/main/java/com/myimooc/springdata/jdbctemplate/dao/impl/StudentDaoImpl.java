package com.myimooc.springdata.jdbctemplate.dao.impl;

import com.myimooc.springdata.jdbctemplate.dao.StudentDao;
import com.myimooc.springdata.jdbctemplate.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * StudentDAO访问接口实现类：通过最原始的JDBC的方式操作
 * Created by ZC on 2017/4/24.
 */
@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Student> listStudent() {
        List<Student> studentList = new ArrayList<Student>();
        String sql = "select id, name, age from student";
        List<Map<String,Object>>  mapList = jdbcTemplate.queryForList(sql);
        for (Map<String,Object> mapTemp : mapList) {
            Integer id = Integer.parseInt(mapTemp.get("id").toString());
            String name = mapTemp.get("name").toString();
            Integer age = Integer.parseInt(mapTemp.get("age").toString());

            Student student = new Student();
            student.setId(id);
            student.setName(name);
            student.setAge(age);

            studentList.add(student);
        }
        return studentList;
    }

    public void saveStudent(Student student) {
        String sql = "insert into student(name, age) value(?,?)";
        jdbcTemplate.update(sql,student.getName(),student.getAge());
    }
}
