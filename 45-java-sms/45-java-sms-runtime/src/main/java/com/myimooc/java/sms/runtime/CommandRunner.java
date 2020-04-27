package com.myimooc.java.sms.runtime;


import com.myimooc.java.sms.service.StudentService;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;

/**
 * 执行命令行命令
 *
 * @author zc
 * @date 2018/05/29
 */
public class CommandRunner {

    /**
     * 服务中服务名与实例的映射关系
     */
    private Map<String, Object> services = new HashMap<>(16);
    /**
     * 服务中方法名与方法的映射关系
     */
    private Map<String, Map<String, Method>> methods = new HashMap<>(16);
    /**
     * 服务中服务名与服务的映射关系
     */
    private Map<String, Class<?>> serviceType = Map.of("student", StudentService.class);

    public CommandRunner() {
        serviceType.forEach((type, clazz) -> {
            ServiceLoader.load(clazz).findFirst().ifPresent(obj -> {
                services.put(type, obj);

                Map<String, Method> map = new HashMap<>(obj.getClass().getDeclaredFields().length);
                for (Method method : obj.getClass().getDeclaredMethods()) {
                    map.put(method.getName(), method);
                }
                methods.put(type, map);

//                methods.put(type, Stream.of(obj.getClass().getDeclaredMethods()).collect(Collectors.toMap(Method::getName, Function.identity())));
            });
        });
    }

    public void run(String service, String task, List<Object> args) {
        Object serviceObj = services.get(service);
        Method method = methods.get(service).get(task);
        try {
            Object result = method.invoke(serviceObj, "1", "1", "2");
            System.out.println(result);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

