package com.myimooc.amap.java.rest;

import com.alibaba.fastjson.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

/**
 * 云存储API 和 云检索API
 *
 * @author zc 2017-08-13
 */
@RestController
public class DemoController {

    private static final String KEY = "you key";
    private static final String API_CREAT_TABLE = "http://yuntuapi.amap.com/datamanage/table/create";
    private static final String API_DATA_CREATE = "http://yuntuapi.amap.com/datamanage/data/create";
    private static final String API_DATA_UPDATE = "http://yuntuapi.amap.com/datamanage/data/update";
    private static final String API_DATA_DELETE = "http://yuntuapi.amap.com/datamanage/data/delete";
    private static final String API_DATA_SEARCH_LOCAL = "http://yuntuapi.amap.com/datasearch/local";

    private static final String SUCCESS_CODE = "1";
    private static final String STATUS = "status";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = {"", "/", "/index"})
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    /**
     * 创建表
     */
    @PostMapping("/tablecreate")
    public Object tableCreate(String name) {
        MultiValueMap<String, String> reqParam = new LinkedMultiValueMap<>();
        reqParam.add("key", KEY);
        reqParam.add("name", name);
        JSONObject result = JSONObject.parseObject(restTemplate.postForObject(API_CREAT_TABLE, reqParam, String.class));
        if (Objects.equals(SUCCESS_CODE, result.getString(STATUS))) {
            return result;
        }
        return JSONObject.parseObject(restTemplate.postForObject(API_CREAT_TABLE, reqParam, String.class));
    }

    /**
     * 创建数据（单条）
     */
    @PostMapping("/datacreate")
    public Object dataCreate(String tableid, String name, String address) {
        MultiValueMap<String, String> reqParam = new LinkedMultiValueMap<>();
        reqParam.add("key", KEY);
        reqParam.add("loctype", "2");
        reqParam.add("tableid", tableid);
        JSONObject data = new JSONObject();
        data.put("_name", name);
        data.put("_address", address);
        reqParam.add("data", data.toString());
        JSONObject result = JSONObject.parseObject(restTemplate.postForObject(API_DATA_CREATE, reqParam, String.class));
        System.out.println(result);
        return result;
    }

    /**
     * 更新数据（单条）
     */
    @PostMapping("/dataupdate")
    public Object dataUpdate(String tableid, String id, String name, String address) {
        MultiValueMap<String, String> reqParam = new LinkedMultiValueMap<>();
        reqParam.add("key", KEY);
        reqParam.add("loctype", "2");
        reqParam.add("tableid", tableid);
        JSONObject data = new JSONObject();
        data.put("_id", id);
        data.put("_name", name);
        data.put("_address", address);
        reqParam.add("data", data.toJSONString());
        JSONObject result = JSONObject.parseObject(restTemplate.postForObject(API_DATA_UPDATE, reqParam, String.class));
        System.out.println(result);
        return result;
    }

    /**
     * 删除数据（单条）
     */
    @PostMapping("/datadelete")
    public Object dataDelete(String tableid, String ids) {
        MultiValueMap<String, String> reqParam = new LinkedMultiValueMap<>();
        reqParam.add("key", KEY);
        reqParam.add("tableid", tableid);
        reqParam.add("ids", ids);

        return JSONObject.parseObject(restTemplate.postForObject(API_DATA_DELETE, reqParam, String.class));
    }

    /**
     * 本地检索
     */
    @PostMapping("/datasearch")
    public Object dataSearch(String tableid, String keywords) {
        String url = API_DATA_SEARCH_LOCAL + "?key=" + KEY + "&tableid=" + tableid + "&city=全国" + "&keywords=" + keywords;
        return JSONObject.parseObject(restTemplate.getForObject(url, String.class));
    }
}
