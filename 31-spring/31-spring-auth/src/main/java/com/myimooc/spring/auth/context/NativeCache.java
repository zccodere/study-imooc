package com.myimooc.spring.auth.context;

import com.myimooc.spring.auth.entity.Function;
import com.myimooc.spring.auth.entity.Role;
import com.myimooc.spring.auth.service.FunctionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

/**
 * 本地缓存服务
 *
 * @author zc 2017-08-20
 */
@Service
public class NativeCache {

    private Map<Long, Function> functionMap = new HashMap<>();
    private Map<Long, List<Role>> userRoleMap = new HashMap<>();

    @Autowired
    private FunctionService functionService;

    /**
     * 使用 @PostConstruct 注解的方法 会在创建该类时执行该方法
     */
    @PostConstruct
    public void init() {
        List<Function> functionList = functionService.getAllFunctions();
        functionList.forEach((function) -> {
            functionMap.put(function.getId(), function);
        });
    }

    public List<Function> getFunctions() {
        if (functionMap.isEmpty()) {
            init();
        }
        return new ArrayList<>(functionMap.values());
    }

    public void addFunction(Function function) {
        functionMap.put(function.getId(), function);
    }

    public void replaceFunction(Function function) {
        if (functionMap.containsKey(function.getId())) {
            functionMap.remove(function.getId());
            functionMap.put(function.getId(), function);
        }
    }

    public void removeFunction(Long functionId) {
        if (functionMap.containsKey(functionId)) {
            functionMap.remove(functionId);
        }
    }

    public void setRole(Long userId, List<Role> roles) {
        userRoleMap.put(userId, roles);
    }

    public List<Role> getRoles(Long userId) {
        return userRoleMap.get(userId);
    }

    public Function getFunction(Long id) {
        return functionMap.get(id);
    }
}
