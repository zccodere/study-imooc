package com.myimooc.spring.auth.controller;

import com.myimooc.spring.auth.common.Whether;
import com.myimooc.spring.auth.context.LoginUserCache;
import com.myimooc.spring.auth.context.NativeCache;
import com.myimooc.spring.auth.context.UserContext;
import com.myimooc.spring.auth.dto.Accordion;
import com.myimooc.spring.auth.entity.Function;
import com.myimooc.spring.auth.entity.Role;
import com.myimooc.spring.auth.entity.RoleFunction;
import com.myimooc.spring.auth.entity.User;
import com.myimooc.spring.auth.entity.UserRole;
import com.myimooc.spring.auth.service.RoleService;
import com.myimooc.spring.auth.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * 登录控制器
 *
 * @author zc 2017-08-20
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private NativeCache nativeCache;
    @Autowired
    private RoleService roleService;

    @GetMapping("auth")
    public String index() {
        if (null != UserContext.getCurrent() && null != UserContext.getCurrent().getUser()) {
            return "/layout/main";
        }
        return "/security/login";
    }

    @PostMapping("login")
    public String login(Model model, String name, String pwd) {
        // 根据用户名和密码查询用户信息
        User user = userService.getUserByNameAndPwd(name, pwd);
        if (null == user) {
            return "/security/login";
        }
        // 将用户信息写入缓存并设置有效期
        LoginUserCache.put(user);

        String roleName = "admin";
        // 获取菜单功能
        if (Objects.equals(roleName, user.getName())) {
            model.addAttribute("accordions", getAccordions(true, null));
        } else {
            List<UserRole> userRoles = userService.getUserRolesByUserId(user.getId());

            if (null == userRoles || 0 == userRoles.size()) {
                return "/security/login";
            }
            List<Long> roleIds = new ArrayList<Long>();
            for (UserRole ur : userRoles) {
                roleIds.add(ur.getRoleId());
            }

            List<Role> roles = roleService.getRoles(roleIds);
            nativeCache.setRole(user.getId(), roles);

            LoginUserCache.put(user);
            List<Accordion> accordions = getAccordions(true, user.getId());
            model.addAttribute("accordions", accordions);
            LoginUserCache.setAccordions(user.getName(), accordions);
        }
        return "/layout/main";
    }

    @GetMapping("logout")
    public String logout() {
        if (null != UserContext.getCurrent() && null != UserContext.getCurrent().getUser()) {
            LoginUserCache.remove(UserContext.getCurrent().getUser().getName());
        }
        return "/security/login";
    }

    private List<Accordion> getAccordions(boolean isAdmin, Long userId) {
        Set<String> permissionUrls = new HashSet<>();
        Set<Long> rootFunctionIdSet = new HashSet<>();

        if (!isAdmin) {
            for (Role role : nativeCache.getRoles(userId)) {
                List<RoleFunction> roleFunctions = roleService.getRoleFunctions(role.getId());

                for (RoleFunction rf : roleFunctions) {
                    Function func = nativeCache.getFunction(rf.getFunctionId());
                    if (Objects.equals(func.getAccordion(), Whether.YES.getValue())) {
                        rootFunctionIdSet.add(func.getId());
                    } else {
                        permissionUrls.add(func.getUrl());
                    }
                }
            }
        }

        Map<Long, Accordion> accordionMap = new HashMap<Long, Accordion>(16);
        List<Accordion> permissionAccordionSet = new LinkedList<>();
        List<Function> founctions = nativeCache.getFunctions();
        List<Accordion> rootAccordionSet = new LinkedList<>();

        for (Function function : founctions) {
            Accordion accordion = new Accordion(function.getId(), function.getParentId(),
                    function.getName(), function.getUrl(), function.getSerialNum());
            accordionMap.put(function.getId(), accordion);
            if (!isAdmin) {
                if (permissionUrls.contains(function.getUrl())) {
                    permissionAccordionSet.add(accordion);
                }
                if (rootFunctionIdSet.contains(function.getId())) {
                    rootAccordionSet.add(accordion);
                }
            } else {
                permissionAccordionSet.add(accordion);
                if (Whether.YES.getValue() == function.getAccordion()) {
                    rootAccordionSet.add(accordion);
                }
            }

        }

        Collections.sort(rootAccordionSet);
        Collections.sort(permissionAccordionSet);
        for (Accordion accordion : rootAccordionSet) {
            complateAccordion(permissionAccordionSet, accordion);
        }
        return rootAccordionSet;

    }

    private void complateAccordion(List<Accordion> permissionAccordionSet, Accordion rootAccordion) {
        for (Accordion accordion : permissionAccordionSet) {
            if (Objects.equals(accordion.getParentId(), rootAccordion.getId())) {
                rootAccordion.getChildren().add(accordion);
            }
        }
    }
}
