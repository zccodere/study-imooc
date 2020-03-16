package com.myimooc.excel.boot.repository;

import com.myimooc.excel.boot.domain.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 学生信息资源层
 *
 * @author zc 2017-07-08
 */
public interface StudentRepository extends JpaRepository<Student, Long> {

}
