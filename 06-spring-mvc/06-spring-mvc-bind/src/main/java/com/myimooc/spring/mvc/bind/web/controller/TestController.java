package com.myimooc.spring.mvc.bind.web.controller;

import com.myimooc.spring.mvc.bind.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by ChengComputer on 2017/2/19.
 *
 * @author zhangcheng
 * @version v1.0
 * @date 2017-02-19
 */
@Controller
public class TestController {

    /**
     * 基本数据类型绑定
     * // http://localhost:8080/bind/baseType.do?xage=10
     *
     * @param age
     * @return
     */
    @RequestMapping(value = "/baseType.do")
    @ResponseBody
    public String baseType(@RequestParam("xage") int age) {
        return "age:" + age;
    }

    /**
     * 包装数据类型绑定
     * // http://localhost:8080/bind/baseType2.do?age=10
     *
     * @param age
     * @return
     */
    @RequestMapping(value = "/baseType2.do")
    @ResponseBody
    public String baseType2(Integer age) {
        return "age:" + age;
    }

    /**
     * 数组类型绑定
     * // http://localhost:8080/bind/array.do?name=Tom&name=Lucy
     *
     * @param name
     * @return
     */
    @RequestMapping(value = "/array.do")
    @ResponseBody
    public String array(String[] name) {

        StringBuilder stringBuilder = new StringBuilder();

        for (String item : name) {
            stringBuilder.append(item).append(" ");
        }
        return stringBuilder.toString();
    }

    /**
     * 简单对象绑定
     * // http://localhost:8080/bind/object.do?name=Tom&age=10
     * // http://localhost:8080/bind/object.do?name=Tom&age=10&
     * //        contactInfo.phone=10086&contactInfo.address=1
     * // http://localhost:8080/bind/object.do?user.name=Tom&
     * //         user.age=10&contactInfo.phone=10086&
     * //         contactInfo.address=1&admin.name=Lucy&admin.age=15
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/object.do")
    @ResponseBody
    public String object(User user, Admin admin) {

        return user.toString() + "   " + admin.toString();
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
     * // http://127.0.0.1:8080/bind/list.do?users[0].name=Tom&users[1].name=Lucy
     * // http://127.0.0.1:8080/bind/list.do?users[0].name=Tom&users[20].name=Lucy
     * @param userListForm
     * @return
     */
    @RequestMapping(value = "list.do")
    @ResponseBody
    public String list(UserListForm userListForm) {
        return "listsize:" + userListForm.getUsers().size() + userListForm.toString();
    }

    /**
     * set对象绑定
     * // http://127.0.0.1:8080/bind/list.do?users[0].name=Tom&users[1].name=Lucy
     * // http://127.0.0.1:8080/bind/list.do?users[0].name=Tom&users[20].name=Lucy
     * @param userSetForm
     * @return
     */
    @RequestMapping(value = "set.do")
    @ResponseBody
    public String set(UserSetForm userSetForm) {
        return userSetForm.toString();
    }

    /**
     * map对象绑定
     * // http://127.0.0.1:8080/bind/map.do?users['x'].name=Tom&
     * //      users['x'].age=10&users['y'].name=Lucy
     * @param userMapForm
     * @return
     */
    @RequestMapping(value = "map.do")
    @ResponseBody
    public String map(UserMapForm userMapForm) {
        return userMapForm.toString();

    }

    /**
     * Json类型数据绑定
     *     {
     "name":"Jim",
     "age":16,
     "contactInfo":{
     "address":"beijing",
     "phone":"10010"
     }
     }
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "json.do")
    @ResponseBody
    public String map(@RequestBody User user) {
        return user.toString();

    }


    /**
     * xml类型数据绑定
     * //    <?xml version="1.0" encoding="UTF-8" ?>
     //    <admin>
     //        <name>Jim</name>
     //        <age>18</age>
     //    </admin>
     * @param admin
     * @return
     */
    @RequestMapping(value = "xml.do")
    @ResponseBody
    public String xml(@RequestBody Admin admin) {
        return admin.toString();

    }


    @RequestMapping(value = "date1.do")
    @ResponseBody
    public String date1(Date date1) {
        return date1.toString();
    }

//    @InitBinder("date1")
//    public void initDate1(WebDataBinder binder){
//        binder.registerCustomEditor(Date.class,
//            new CustomDateEditor(
//                new SimpleDateFormat("yyyy-MM-dd"),true));
//    }

    @RequestMapping(value = "date2.do")
    @ResponseBody
    public String date2(Date date2) {
        return date2.toString();
    }


    @GetMapping(value = "/book")
    @ResponseBody
    public String book(HttpServletRequest request) {
        String contentType = request.getContentType();
        if (contentType == null) {
            return "book.default";
        }
        String typeTxt = "txt";
        if (typeTxt.equalsIgnoreCase(contentType)) {
            return "book.txt";
        }
        String typeHtml = "html";
        if (typeHtml.equalsIgnoreCase(contentType)) {
            return "book.html";
        }
        return "book.default";
    }


    /**
     * 获取资源
     *
     * @param subjectId
     * @return
     */
    @GetMapping(value = "/subject/{subjectId}")
    @ResponseBody
    public String getSubject(@PathVariable("subjectId") String subjectId) {
        return "this is get method,subject:" + subjectId;
    }

    /**
     * 创建资源
     *
     * @param subjectId
     * @return
     */
    @PostMapping(value = "/subject/{subjectId}")
    @ResponseBody
    public String postSubject(@PathVariable("subjectId") String subjectId) {
        return "this is post method,subject:" + subjectId;
    }

    /**
     * 删除资源
     *
     * @param subjectId
     * @return
     */
    @DeleteMapping(value = "/subject/{subjectId}")
    @ResponseBody
    public String deleteSubject(@PathVariable("subjectId") String subjectId) {
        return "this is delete method,subject:" + subjectId;
    }

    /**
     * 修改或创建资源
     *
     * @param subjectId
     * @return
     */
    @PutMapping(value = "/subject/{subjectId}")
    @ResponseBody
    public String putSubject(@PathVariable("subjectId") String subjectId) {
        return "this is put method,subject:" + subjectId;
    }


}
