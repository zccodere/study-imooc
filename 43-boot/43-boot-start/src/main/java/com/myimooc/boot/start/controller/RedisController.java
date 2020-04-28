package com.myimooc.boot.start.controller;

import com.myimooc.boot.start.dao.po.SysUser;
import com.myimooc.boot.start.domain.JsonResult;
import com.myimooc.boot.start.domain.User;
import com.myimooc.boot.start.util.JsonUtils;
import com.myimooc.boot.start.util.RedisOperator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 整合redis
 *
 * @author zc 2018-04-26
 */
@RestController
@RequestMapping("redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate strRedis;
    @Autowired
    private RedisOperator redis;

    @RequestMapping("/test")
    public JsonResult test() {
        strRedis.opsForValue().set("imooc-cache", "hello 慕课网~~~~~~");
        SysUser user = new SysUser();
        user.setId("100111");
        user.setUsername("imooc");
        user.setPassword("abc123");
        user.setIsDelete(0);
        user.setRegistTime(new Date());
        strRedis.opsForValue().set("json:user", JsonUtils.objectToJson(user));
        SysUser jsonUser = JsonUtils.jsonToObject(strRedis.opsForValue().get("json:user"), SysUser.class);
        return JsonResult.ok(jsonUser);
    }

    @RequestMapping("/getJsonList")
    public JsonResult getJsonList() {

        User user = new User();
        user.setAge(18);
        user.setName("慕课网");
        user.setPassword("123456");
        user.setBirthday(new Date());

        User u1 = new User();
        u1.setAge(19);
        u1.setName("imooc");
        u1.setPassword("123456");
        u1.setBirthday(new Date());

        User u2 = new User();
        u2.setAge(17);
        u2.setName("hello imooc");
        u2.setPassword("123456");
        u2.setBirthday(new Date());

        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(u1);
        userList.add(u2);

        redis.set("json:info:user-list", JsonUtils.objectToJson(userList), 2000);

        String userListJson = redis.get("json:info:user-list");
        List<User> userListBorn = JsonUtils.jsonToList(userListJson, User.class);

        return JsonResult.ok(userListBorn);
    }
}
