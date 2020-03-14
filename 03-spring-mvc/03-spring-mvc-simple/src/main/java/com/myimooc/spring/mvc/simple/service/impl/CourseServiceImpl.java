package com.myimooc.spring.mvc.simple.service.impl;

import com.myimooc.spring.mvc.simple.model.entity.Chapter;
import com.myimooc.spring.mvc.simple.model.entity.Course;
import com.myimooc.spring.mvc.simple.service.CourseService;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 课程业务功能实现类
 *
 * @author zc 2017-02-18
 */
@Service("courseService")
public class CourseServiceImpl implements CourseService {

    @Override
    public Course getCourseById(Integer courseId) {

        Course course = new Course();

        course.setCourseId(courseId);
        course.setTitle("深入浅出Java多线程");
        course.setImgPath("static/img/course-img.jpg");
        course.setLevel(2);
        course.setLearnNum(12345);
        course.setLevelDesc("中级");
        course.setDuration(7200L);
        course.setDescription("多线程是日常开发中的常用知识，也是难用知识。ba la ba la...");

        List<Chapter> chapterList = new ArrayList<>();

        warpChapterList(courseId, chapterList);

        course.setChapterList(chapterList);

        return course;
    }

    private void warpChapterList(Integer courseId, List<Chapter> chapterList) {
        Chapter chapter1 = new Chapter();
        chapter1.setId(1);
        chapter1.setOrder(1);
        chapter1.setCourseId(courseId);
        chapter1.setTitle("第1章 多线程背景知识介绍");
        chapter1.setDescription("本章将介绍与多线程编程相关的背景概念");
        chapterList.add(chapter1);

        Chapter chapter2 = new Chapter();
        chapter2.setId(2);
        chapter2.setCourseId(courseId);
        chapter2.setOrder(2);
        chapter2.setTitle("第2章 Java 线程初体验");
        chapter2.setDescription("Java语言层面对线程的支持，如何创建，启动和停止线程。如何使用常用的线程方法。用隋唐演义理解线程的代码");
        chapterList.add(chapter2);

        Chapter chapter3 = new Chapter();
        chapter3.setId(3);
        chapter3.setCourseId(courseId);
        chapter3.setOrder(3);
        chapter3.setTitle("第3章 Java 线程的正确停止");
        chapter3.setDescription("本章讨论如何正确的停止一个线程，既要线程停得了，还得线程停得好。");
        chapterList.add(chapter3);

        Chapter chapter4 = new Chapter();
        chapter4.setId(4);
        chapter4.setCourseId(courseId);
        chapter4.setOrder(4);
        chapter4.setTitle("第4章 线程交互");
        chapter4.setDescription("争用条件，线程的交互，及死锁的成因及预防。");
        chapterList.add(chapter4);

        Chapter chapter5 = new Chapter();
        chapter5.setId(5);
        chapter5.setCourseId(courseId);
        chapter5.setOrder(5);
        chapter5.setTitle("第5章 进阶展望");
        chapter5.setDescription("简单介绍 Java 并发相关的类，及常用的多线程编程模型。");
        chapterList.add(chapter5);

    }
}
