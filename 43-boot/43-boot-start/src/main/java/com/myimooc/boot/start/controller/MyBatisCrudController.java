package com.myimooc.boot.start.controller;

import com.myimooc.boot.start.dao.po.SysUser;
import com.myimooc.boot.start.domain.JsonResult;
import com.myimooc.boot.start.service.UserService;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * <br>
 * 标题: 基于Mybatis实现的CRUD例子<br>
 * 描述: 控制器<br>
 *
 * @author zc
 * @date 2018/04/26
 */
@RestController
@RequestMapping("mybatis")
public class MyBatisCrudController {

    @Autowired
    private UserService userService;

    @Autowired
    private Sid sid;

    @RequestMapping("/saveUser")
    public JsonResult saveUser() throws Exception {
        String userId = sid.nextShort();
        SysUser user = new SysUser();
        user.setId(userId);
        user.setUsername("imooc" + new Date());
        user.setNickname("imooc" + new Date());
        user.setPassword("abc123");
        user.setIsDelete(0);
        user.setRegistTime(new Date());
        userService.create(user);
        return JsonResult.ok("保存成功");
    }

    @RequestMapping("/updateUser")
    public JsonResult updateUser() {
        SysUser user = new SysUser();
        user.setId("10011001");
        user.setUsername("10011001-updated" + new Date());
        user.setNickname("10011001-updated" + new Date());
        user.setPassword("10011001-updated");
        user.setIsDelete(0);
        user.setRegistTime(new Date());
        userService.update(user);
        return JsonResult.ok("保存成功");
    }

    @RequestMapping("/deleteUser")
    public JsonResult deleteUser(String userId) {
        userService.remove(userId);
        return JsonResult.ok("删除成功");
    }
    @RequestMapping("/queryUserById")
    public JsonResult queryUserById(String userId) {
        return JsonResult.ok(userService.queryById(userId));
    }
    @RequestMapping("/queryUserList")
    public JsonResult queryUserList() {
        SysUser user = new SysUser();
        user.setUsername("imooc");
        user.setNickname("lee");
        List<SysUser> userList = userService.queryUserList(user);
        return JsonResult.ok(userList);
    }

    @RequestMapping("/queryUserListPaged")
    public JsonResult queryUserListPaged(Integer page) {
        if (page == null) {
            page = 1;
        }
        int pageSize = 10;
        SysUser user = new SysUser();
        List<SysUser> userList = userService.queryUserListPaged(user, page, pageSize);
        return JsonResult.ok(userList);
    }

    @RequestMapping("/queryUserByIdCustom")
    public JsonResult queryUserByIdCustom(String userId) {
        return JsonResult.ok(userService.queryUserByIdCustom(userId));
    }

    @RequestMapping("/saveUserTransactional")
    public JsonResult saveUserTransactional() {
        String userId = sid.nextShort();
        SysUser user = new SysUser();
        user.setId(userId);
        user.setUsername("lee" + new Date());
        user.setNickname("lee" + new Date());
        user.setPassword("abc123");
        user.setIsDelete(0);
        user.setRegistTime(new Date());
        userService.saveUserTransactional(user);
        return JsonResult.ok("保存成功");
    }
}
