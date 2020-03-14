package com.myimooc.spring.mvc.interceptor.web.controller;

import com.myimooc.spring.mvc.interceptor.model.entity.Course;
import com.myimooc.spring.mvc.interceptor.service.CourseService;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

/**
 * 课程相关控制器
 *
 * @author zc 2017-02-08
 */
@Controller
@RequestMapping("/course")
public class CourseController {

    private Logger log = LoggerFactory.getLogger(CourseController.class);

    @Resource(name = "courseService")
    private CourseService courseService;

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String viewCourse(@RequestParam("courseId") Integer courseId, Model model) {
        log.debug("courseId:" + courseId);
        Course course = courseService.getCourseById(courseId);
        model.addAttribute(course);
        return "course_overview";
    }

    @RequestMapping(value = "/view2/{courseId}", method = RequestMethod.GET)
    public ModelAndView viewCourse2(@PathVariable("courseId") Integer courseId, ModelAndView modelAndView) {
        log.debug("courseId:" + courseId);
        Course course = courseService.getCourseById(courseId);
        modelAndView.addObject("course", course);
        modelAndView.setViewName("course_overview");
        return modelAndView;
    }

    @RequestMapping("view3")
    public String viewCourse3(@RequestParam Integer courseId, ModelAndView modelAndView) {
        log.debug("courseId:" + courseId);
        Course course = courseService.getCourseById(courseId);
        modelAndView.addObject("course", course);
        return "course_overview";
    }

    /**
     * 添加课程
     */
    @RequestMapping(value = "/admin", method = RequestMethod.GET, params = "add")
    public String createCourse() {
        return "course_admin/edit";
    }

    /**
     * 保存课程
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String doSave(@ModelAttribute Course course) {
        log.debug("Info of Course.");
        log.debug(ReflectionToStringBuilder.toString(course));
        //在此进行业务操作，比如数据库持久化。
        course.setCourseId(123);
        return "redirect:view2/" + course.getCourseId();
    }

    /**
     * 跳转到文件上传页面
     */
    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String showUploadPage() {
        return "course_admin/file";
    }

    /**
     * 文件上传成功，跳转到成功页面
     */
    @RequestMapping(value = "/doUpload", method = RequestMethod.POST)
    public String doUpload(@RequestParam("file") MultipartFile file) throws IOException {

        if (!file.isEmpty()) {
            log.debug("正在处理文件：" + file.getOriginalFilename());
            File fileTemp = new File("/upload", System.currentTimeMillis() + file.getOriginalFilename());

            log.debug(fileTemp.getAbsolutePath());
            FileUtils.copyInputStreamToFile(file.getInputStream(), fileTemp);
        }
        return "success";
    }

    @RequestMapping(value = "/json/{courseId}", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getCourseInJson(@PathVariable Integer courseId) {
        Map<String, Object> resultMap = new HashMap<>(16);
        resultMap.put("code", "200");
        Course course = courseService.getCourseById(courseId);
        log.debug(course.toString());
        resultMap.put("course", course);
        return resultMap;
    }

    @RequestMapping(value = "/{courseId}", method = RequestMethod.GET)
    @ResponseBody
    public Course getCourse(@PathVariable Integer courseId) {
        Course course = courseService.getCourseById(courseId);
        log.debug(course.toString());
        return course;
    }
}
