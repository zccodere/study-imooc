package com.myimooc.excel.boot.service;

import com.myimooc.excel.boot.domain.model.Student;
import com.myimooc.excel.boot.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 学生信息服务层
 *
 * @author zc 2017-07-08
 */
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> list() {
        return studentRepository.findAll();
    }

}
