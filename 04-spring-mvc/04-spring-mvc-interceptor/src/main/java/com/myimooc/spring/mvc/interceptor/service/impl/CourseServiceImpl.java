package com.myimooc.spring.mvc.interceptor.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.myimooc.spring.mvc.interceptor.model.entity.Chapter;
import com.myimooc.spring.mvc.interceptor.model.entity.Course;
import com.myimooc.spring.mvc.interceptor.service.CourseService;
import org.springframework.stereotype.Service;

/**
 * 课程业务功能实现类
 * @author zhangcheng
 * @version v1.0 2017-02-18
 *
 */
@Service("courseService")
public class CourseServiceImpl implements CourseService {
    
    @Override
	public Course getCourseById(Integer courseId) {
		
		Course course = new Course();
		
		course.setCourseId(courseId);
		course.setTitle("深入浅出Java多线程");
		course.setImgPath("static/imgs/course-img.jpg");
		course.setLearningNum(12345);
		course.setLevel(2);
		course.setLevelDesc("中级");
		course.setDuration(7200L);
		course.setDescr("多线程是日常开发中的常用知识，也是难用知识。bala bala...");
		
		List<Chapter> chapterList = new ArrayList<Chapter>();
		
		warpChapterList(courseId,chapterList);
		
		course.setChapterList(chapterList);
		
		return course;
	}

	private void warpChapterList(Integer courseId,List<Chapter> chapterList) {
		Chapter chapter = new Chapter();
		chapter.setId(1);
		chapter.setCourseId(courseId);
		chapter.setOrder(1);
		chapter.setTitle("第1章 多线程背景知识介绍");
		chapter.setDescr("本章将介绍与多线程编程相关的背景概念");	
		chapterList.add(chapter);
		
		chapter = new Chapter();
		chapter.setId(2);
		chapter.setCourseId(courseId);
		chapter.setOrder(2);
		chapter.setTitle("第2章 Java 线程初体验");
		chapter.setDescr("Java语言层面对线程的支持，如何创建，启动和停止线程。如何使用常用的线程方法。用隋唐演义理解线程的代码");
		chapterList.add(chapter);
		
		chapter = new Chapter();
		chapter.setId(3);
		chapter.setCourseId(courseId);
		chapter.setOrder(3);
		chapter.setTitle("第3章 Java 线程的正确停止");
		chapter.setDescr("本章讨论如何正确的停止一个线程，既要线程停得了，还得线程停得好。");		
		chapterList.add(chapter);
		
		chapter = new Chapter();
		chapter.setId(4);
		chapter.setCourseId(courseId);
		chapter.setOrder(4);
		chapter.setTitle("第4章 线程交互");
		chapter.setDescr("争用条件，线程的交互，及死锁的成因及预防。");		
		chapterList.add(chapter);
		
		chapter = new Chapter();
		chapter.setId(5);
		chapter.setCourseId(courseId);
		chapter.setOrder(5);
		chapter.setTitle("第5章 进阶展望");
		chapter.setDescr("简单介绍 Java 并发相关的类，及常用的多线程编程模型。");		
		chapterList.add(chapter);
		
	}
}
