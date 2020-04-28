package com.myimooc.spring.mvc.interceptor.service;

import com.myimooc.spring.mvc.interceptor.model.entity.Course;

/**
 * 课程业务功能接口
 *
 * @author zc 2017-02-18
 */
public interface CourseService {

    /**
     * 通过ID获取课程
     *
     * @param courseId 课程ID
     * @return 课程
     */
    Course getCourseById(Integer courseId);
}
