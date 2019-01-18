package com.imooc.mvcdemo.service;

import org.springframework.stereotype.Service;

import com.imooc.mvcdemo.model.Course;

@Service
public interface CourseService {
	
	
	Course getCoursebyId(Integer courseId);
	

	
	

}
