package com.myimooc.myexcelweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myimooc.myexcelweb.domain.model.Student;
import com.myimooc.myexcelweb.repository.StudentRepository;

/**
 * 学生信息业务类
 * @author ZhangCheng on 2017-07-08
 *
 */
@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> list(){
		return studentRepository.findAll();
	}
	
}
