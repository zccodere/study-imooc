package com.myimooc.boot.web.controller;

import com.myimooc.boot.web.AbstractTestSupport;

import org.junit.Test;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Hello控制层测试类
 *
 * @author zc 2020-03-14
 */
public class HelloControllerTest extends AbstractTestSupport {

    @Test
    public void say() throws Exception {
        String response = mockMvc.perform(get("/hello/say")
                .contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        System.out.println(response);
    }

    @Test
    public void sayOne() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>(16);
        params.add("id", "5");

        String response = mockMvc.perform(get("/hello/say/one")
                .contentType(APPLICATION_JSON_UTF8)
                .params(params))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        System.out.println(response);
    }
}
