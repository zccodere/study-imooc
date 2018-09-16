package com.myimooc.spring.mvc.interceptor.service;

import com.myimooc.spring.mvc.interceptor.model.entity.Course;

/**
 * 课程业务功能接口
 *
 * @author zhangcheng
 * @version v1.0 2017-02-18
 */
public interface CourseService {
    /**
     * 通过ID获取课程
     *
     * @param courseId
     * @return
     */
    Course getCourseById(Integer courseId);
}
