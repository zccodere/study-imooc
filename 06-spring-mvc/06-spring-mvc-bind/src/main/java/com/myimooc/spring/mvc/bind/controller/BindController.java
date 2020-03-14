package com.myimooc.spring.mvc.bind.controller;

import com.myimooc.spring.mvc.bind.model.Admin;
import com.myimooc.spring.mvc.bind.model.User;
import com.myimooc.spring.mvc.bind.model.UserListForm;
import com.myimooc.spring.mvc.bind.model.UserMapForm;
import com.myimooc.spring.mvc.bind.model.UserSetForm;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

/**
 * 测试控制层
 *
 * @author zc 2017-02-19
 */
@Controller
@ResponseBody
public class BindController {

    /**
     * 基本数据类型绑定
     */
    @RequestMapping(value = "/baseType")
    public String baseType(@RequestParam("age") int age) {
        return "age:" + age;
    }

    /**
     * 包装数据类型绑定
     */
    @RequestMapping(value = "/baseType2")
    public String baseType2(Integer age) {
        return "age:" + age;
    }

    /**
     * 数组类型绑定
     */
    @RequestMapping(value = "/array")
    public String array(String[] name) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String item : name) {
            stringBuilder.append(item).append(" ");
        }
        return stringBuilder.toString();
    }

    /**
     * 简单对象绑定
     */
    @RequestMapping(value = "/object")
    public String object(User user, Admin admin) {
        return user.toString() + " ### " + admin.toString();
    }

    @InitBinder("user")
    public void initUser(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("user.");
    }

    @InitBinder("admin")
    public void initAdmin(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("admin.");
    }

    /**
     * List对象绑定
     */
    @RequestMapping(value = "list")
    public String list(UserListForm userListForm) {
        return "listSize:" + userListForm.getUsers().size() + userListForm.toString();
    }

    /**
     * set对象绑定
     */
    @RequestMapping(value = "set")
    public String set(UserSetForm userSetForm) {
        return userSetForm.toString();
    }

    /**
     * map对象绑定
     */
    @RequestMapping(value = "map")
    public String map(UserMapForm userMapForm) {
        return userMapForm.toString();
    }

    /**
     * Json类型数据绑定
     */
    @RequestMapping(value = "json")
    public String json(@RequestBody User user) {
        return user.toString();
    }

    /**
     * xml类型数据绑定
     */
    @RequestMapping(value = "xml", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public String xml(@RequestBody Admin admin) {
        return admin.toString();
    }

    @RequestMapping(value = "date1")
    public String date1(Date date1) {
        return date1.toString();
    }

    @InitBinder("date1")
    public void initDate1(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd"), true));
    }

    @RequestMapping(value = "date2")
    public String date2(Date date2) {
        return Objects.nonNull(date2) ? date2.toString() : "绑定date2参数失败，date2为null";
    }

    /**
     * 自定义 contentType
     */
    @GetMapping(value = "/book")
    public String book(HttpServletRequest request) {
        String contentType = request.getContentType();
        if (contentType == null) {
            return "book.default";
        }
        String typeTxt = "zccoder/txt";
        if (typeTxt.equalsIgnoreCase(contentType)) {
            return "book.txt";
        }
        String typeHtml = "zccoder/html";
        if (typeHtml.equalsIgnoreCase(contentType)) {
            return "book.html";
        }
        return "book.default";
    }

    /**
     * 获取资源
     */
    @GetMapping(value = "/subject/{subjectId}")
    public String getSubject(@PathVariable("subjectId") String subjectId) {
        return "this is get method,subject:" + subjectId;
    }

    /**
     * 创建资源
     */
    @PostMapping(value = "/subject/{subjectId}")
    public String postSubject(@PathVariable("subjectId") String subjectId) {
        return "this is post method,subject:" + subjectId;
    }

    /**
     * 删除资源
     */
    @DeleteMapping(value = "/subject/{subjectId}")
    public String deleteSubject(@PathVariable("subjectId") String subjectId) {
        return "this is delete method,subject:" + subjectId;
    }

    /**
     * 修改或创建资源
     */
    @PutMapping(value = "/subject/{subjectId}")
    public String putSubject(@PathVariable("subjectId") String subjectId) {
        return "this is put method,subject:" + subjectId;
    }
}
