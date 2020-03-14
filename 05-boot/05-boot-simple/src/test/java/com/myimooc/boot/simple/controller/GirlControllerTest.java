package com.myimooc.boot.simple.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.myimooc.boot.simple.AbstractTestSupport;
import com.myimooc.boot.simple.model.entity.Girl;

import org.junit.Test;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Girl 控制层测试类
 *
 * @author zc 2017-02-18
 */
public class GirlControllerTest extends AbstractTestSupport {

    /**
     * 查询所有女生列表
     */
    @Test
    public void listGirl() throws Exception {
        String response = mockMvc.perform(get("/girls")
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        System.out.println(response);
    }

    /**
     * 添加一个女生
     */
    @Test
    public void girlAdd() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>(16);
        params.add("cupSize", "B");
        params.add("age", "20");

        String response = mockMvc.perform(post("/girls")
                .contentType(APPLICATION_JSON_UTF8)
                .params(params))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        System.out.println(response);
    }

    /**
     * 查询一个女生
     */
    @Test
    public void getGirlById() throws Exception {
        int id = 3;

        String response = mockMvc.perform(get("/girls/" + id)
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        TypeReference<Girl> typeReference = new TypeReference<Girl>() {
        };
        Girl girl = objectMapper.readValue(response, typeReference);
        System.out.println(girl);
    }

    /**
     * 更新女生信息
     */
    @Test
    public void updateGirlById() throws Exception {
        int id = 3;
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>(16);
        params.add("cupSize", "C");
        params.add("age", "22");

        String response = mockMvc.perform(put("/girls/" + id)
                .contentType(APPLICATION_JSON_UTF8)
                .params(params))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        TypeReference<Girl> typeReference = new TypeReference<Girl>() {
        };
        Girl girl = objectMapper.readValue(response, typeReference);
        System.out.println(girl);
    }

    /**
     * 删除女生信息
     */
    @Test
    public void removeGirl() throws Exception {
        int id = 2;

        String response = mockMvc.perform(delete("/girls/" + id)
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        System.out.println(response);
    }

    /**
     * 通过年龄查询女生列表
     */
    @Test
    public void listGirlByAge() throws Exception {
        int age = 18;

        String response = mockMvc.perform(get("/girls/age/" + age)
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        TypeReference<List<Girl>> typeReference = new TypeReference<List<Girl>>() {
        };
        List<Girl> list = objectMapper.readValue(response, typeReference);
        System.out.println(list);
    }

    /**
     * 保存两个女生信息
     */
    @Test
    public void saveGirlTwo() throws Exception {
        String response = mockMvc.perform(post("/girls/two")
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        System.out.println(response);
    }
}
