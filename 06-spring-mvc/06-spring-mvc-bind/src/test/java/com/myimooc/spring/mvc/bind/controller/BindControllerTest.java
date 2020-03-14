package com.myimooc.spring.mvc.bind.controller;

import com.myimooc.spring.mvc.bind.AbstractTestSupport;
import com.myimooc.spring.mvc.bind.model.ContactInfo;
import com.myimooc.spring.mvc.bind.model.User;

import org.junit.Test;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 测试控制层测试类
 *
 * @author zc 2020-03-14
 */
public class BindControllerTest extends AbstractTestSupport {

    /**
     * 基本数据类型绑定
     */
    @Test
    public void baseType() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>(16);
        params.add("age", "20");

        String response = mockMvc.perform(get("/baseType")
                .contentType(APPLICATION_JSON_UTF8)
                .params(params))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        System.out.println(response);
    }

    /**
     * 包装数据类型绑定
     */
    @Test
    public void baseType2() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>(16);
        params.add("age", "20");

        String response = mockMvc.perform(get("/baseType")
                .contentType(APPLICATION_JSON_UTF8)
                .params(params))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        System.out.println(response);
    }

    /**
     * 数组类型绑定
     */
    @Test
    public void array() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>(16);
        // 使用英文逗号分隔传递数组类型参数
        params.add("name", "Tom,Lucy");

        String response = mockMvc.perform(get("/array")
                .contentType(APPLICATION_JSON_UTF8)
                .params(params))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        System.out.println(response);
    }

    /**
     * 简单对象绑定
     */
    @Test
    public void object() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>(16);

        // User 对象参数绑定
        params.add("name", "Tom");
        params.add("age", "20");
        params.add("contactInfo.phone", "10086");
        params.add("contactInfo.address", "11号");

        // Admin 对象参数绑定
        params.add("admin.name", "Lucy");
        params.add("admin.age", "18");

        String response = mockMvc.perform(get("/object")
                .contentType(APPLICATION_JSON_UTF8)
                .params(params))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        System.out.println(response);
    }

    /**
     * List对象绑定
     */
    @Test
    public void list() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>(16);
        // 请求参数数组的下标会影响接收端List的大小
        params.add("users[0].name", "Tome");
        params.add("users[20].name", "Lucy");

        String response = mockMvc.perform(get("/list")
                .contentType(APPLICATION_JSON_UTF8)
                .params(params))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        System.out.println(response);
    }

    /**
     * set对象绑定
     */
    @Test
    public void set() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>(16);
        // 请求参数数组的长度必须小于接收端Set的大小，否则无法绑定值
        params.add("users[0].name", "Tome");

        String response = mockMvc.perform(get("/set")
                .contentType(APPLICATION_JSON_UTF8)
                .params(params))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        System.out.println(response);
    }

    /**
     * map对象绑定
     */
    @Test
    public void map() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>(16);
        params.add("users['x'].name", "Tom");
        params.add("users['y'].age", "1");
        params.add("users['y'].name", "Lucy");

        String response = mockMvc.perform(get("/map")
                .contentType(APPLICATION_JSON_UTF8)
                .params(params))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        System.out.println(response);
    }

    /**
     * json类型数据绑定
     */
    @Test
    public void json() throws Exception {
        User user = new User();
        user.setName("Jim");
        user.setAge(16);
        ContactInfo contactInfo = new ContactInfo();
        contactInfo.setAddress("beijing");
        contactInfo.setPhone("10010");
        user.setContactInfo(contactInfo);

        String request = super.objectMapper.writeValueAsString(user);
        System.out.println(request);
        String response = mockMvc.perform(post("/json")
                .contentType(APPLICATION_JSON_UTF8)
                .content(request))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        System.out.println(response);
    }

    /**
     * xml类型数据绑定
     */
    @Test
    public void xml() throws Exception {
        String request = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?><admin><name>Jim</name><age>18</age></admin>";
        String response = mockMvc.perform(post("/xml")
                .contentType(APPLICATION_XML_VALUE)
                .content(request))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        System.out.println(response);
    }

    @Test
    public void date1() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>(16);
        params.add("date1", "2020-03-14");

        String response = mockMvc.perform(get("/date1")
                .contentType(APPLICATION_JSON_UTF8)
                .params(params))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        System.out.println(response);
    }

    @Test
    public void date2() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>(16);
        params.add("date2", "2020-03-14");

        String response = mockMvc.perform(get("/date2")
                .contentType(APPLICATION_JSON_UTF8)
                .params(params))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        System.out.println(response);
    }

    /**
     * 自定义 contentType
     */
    @Test
    public void book() throws Exception {
        String contentType = "zccoder/txt";

        String response = mockMvc.perform(get("/book")
                .contentType(contentType))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        System.out.println(response);
    }

    /**
     * 获取资源
     */
    @Test
    public void getSubject() throws Exception {
        String subjectId = "111";

        String response = mockMvc.perform(get("/subject/" + subjectId)
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        System.out.println(response);
    }

    /**
     * 创建资源
     */
    @Test
    public void postSubject() throws Exception {
        String subjectId = "111";

        String response = mockMvc.perform(post("/subject/" + subjectId)
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        System.out.println(response);
    }

    /**
     * 删除资源
     */
    @Test
    public void deleteSubject() throws Exception {
        String subjectId = "111";

        String response = mockMvc.perform(delete("/subject/" + subjectId)
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        System.out.println(response);
    }

    /**
     * 修改或创建资源
     */
    @Test
    public void putSubject() throws Exception {
        String subjectId = "111";

        String response = mockMvc.perform(put("/subject/" + subjectId)
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        System.out.println(response);
    }
}
