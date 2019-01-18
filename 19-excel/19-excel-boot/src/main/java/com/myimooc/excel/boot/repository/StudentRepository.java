package com.myimooc.excel.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myimooc.excel.boot.domain.model.Student;

/**
 * 学生信息资源接口
 * @author ZhangCheng on 2017-07-08
 *
 */
public interface StudentRepository extends JpaRepository<Student, Long> {

}
