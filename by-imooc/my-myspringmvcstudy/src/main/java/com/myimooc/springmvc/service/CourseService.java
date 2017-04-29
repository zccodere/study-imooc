package com.myimooc.springmvc.service;

import com.myimooc.springmvc.model.entity.Course;

/**
 * 课程业务功能接口
 * @author zhangcheng
 * @version v1.0 2017-02-18
 *
 */
public interface CourseService {

    Course getCourseById(Integer courseId);
}
