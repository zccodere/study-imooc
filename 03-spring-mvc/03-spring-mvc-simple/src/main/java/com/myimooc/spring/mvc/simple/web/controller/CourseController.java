package com.myimooc.spring.mvc.simple.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.myimooc.spring.mvc.simple.service.CourseService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
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

import com.myimooc.spring.mvc.simple.model.entity.Course;

/**
 * 课程相关控制器
 * @author zhangcheng
 * @version v1.0 2017-02-08
 *
 */
@SuppressWarnings("unused")
@Controller
@RequestMapping("/course")
public class CourseController {
    
    private Logger log = LoggerFactory.getLogger(CourseController.class);
    
    @Resource(name="courseService")
    private CourseService courseService;
    
    @RequestMapping(value="/view",method=RequestMethod.GET)
    public String viewCourse(@RequestParam("courseId")Integer courseId,Model model){
        log.debug("courseId:"+courseId);
        Course course = courseService.getCourseById(courseId);
        model.addAttribute(course);
        
        return "course_overview";
    }
    
    @RequestMapping(value="/view2/{courseId}",method=RequestMethod.GET)
    public String viewCourse2(@PathVariable("courseId")Integer courseId,Map<String,Object> model){
        log.debug("courseId:"+courseId);
        Course course = courseService.getCourseById(courseId);
        model.put("course", course);
        return "course_overview";
    }
    
    @RequestMapping("view3")
    public String viewCourse3(HttpServletRequest request){
        Integer courseId = Integer.valueOf(request.getParameter("courseId"));
        log.debug("courseId:"+courseId);
        Course course = courseService.getCourseById(courseId);
        request.setAttribute("course", course);
        return "course_overview";
    }
    
    /**
     * 添加课程
     */
    @RequestMapping(value="/admin",method=RequestMethod.GET,params="add")
    public String createCourse(){
        return "course_admin/edit";
    }
    
    /**
     * 保存课程
     */
    @RequestMapping(value="/save",method=RequestMethod.POST)
    public String doSave(@ModelAttribute Course course){
        log.debug("Info of Course.");
        log.debug(ReflectionToStringBuilder.toString(course));
        //在此进行业务操作，比如数据库持久化。
        course.setCourseId(123);
        
        
        return "redirect:view2/"+course.getCourseId();
    
    }
    
    /**
     * 跳转到文件上传页面
     * @return
     */
    @RequestMapping(value="/upload",method=RequestMethod.GET)
    public String showUploadPage(){
        return "course_admin/file";
    }
    
    /**
     * 文件上传成功，跳转到成功页面
     * @return
     * @throws IOException 
     */
    @RequestMapping(value="/doUpload",method=RequestMethod.POST)
    public String doUpload(@RequestParam("file") MultipartFile file,HttpServletRequest request) throws IOException{
        
        if(!file.isEmpty()){
            log.debug("正在处理文件："+file.getOriginalFilename());
            File fileTemp = new File("/upload",System.currentTimeMillis()+file.getOriginalFilename());
            
            log.debug(fileTemp.getAbsolutePath());
            FileUtils.copyInputStreamToFile(file.getInputStream(),fileTemp);
        }
        return "success";
    }
    
//    @RequestMapping(value="/{courseId}",method=RequestMethod.GET)
//    @ResponseBody
//    public Map<String,Object> getCourseInJson(@PathVariable Integer courseId){
//        
//        Map<String,Object> resultMap = new HashMap<String,Object>();
//        
//        resultMap.put("code", "200");
//        
//        Course couesr = courseService.getCourseById(courseId);
//        log.debug(couesr.toString());
//        
//        resultMap.put("couesr", couesr);
//        
//        return resultMap;
//    }
    
    @RequestMapping(value="/{courseId}",method=RequestMethod.GET)
    @ResponseBody
    public Course getCourse(@PathVariable Integer courseId){
        
        
        Course couesr = courseService.getCourseById(courseId);
        log.debug(couesr.toString());
        return couesr;
    }
}
