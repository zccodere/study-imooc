package com.myimooc.boot.module.web.config;

import com.myimooc.boot.module.domain.User;
import com.myimooc.boot.module.web.repository.UserRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.util.Collection;

import reactor.core.publisher.Flux;

/**
 * 路由器函数配置；配置映射
 *
 * @author zc 2018-04-08
 */
@Configuration
public class RouterFunctionConfiguration {

    /**
     * Servlet 规范
     * <p>
     * 请求接口：ServletRequest 或者 HttpServletRequest； 响应接口：ServletResponse 或者 HttpServletResponse。
     * </p>
     *
     * Spring 5.0 重新定义了服务请求的响应接口
     * <p>
     * 请求接口：ServerRequest； 响应接口：ServerResponse。
     * </p>
     * 即可支持 Servlet 规范，也可以支持自定义，比如 Netty （Web Server） 以本例 定义 GET 请求，并且放回所有的用户对象
     * URI：/person/find/all；
     * <p>
     * Flux 是 0 - N 个对象集合； Mono 是 0 - 1 个对象集合。
     * </p>
     * Reactive 中的 Flux 或者 Mono 是异步处理（非阻塞） 集合对象基本上是同步处理（阻塞） Flux 或者 Mono 都是 Publisher
     */
    @Bean
    public RouterFunction<ServerResponse> personFindAll(UserRepository userRepository) {
        Collection<User> users = userRepository.findAll();
        return RouterFunctions.route(RequestPredicates.GET("/person/find/all"),
                request -> {
                    Flux<User> userFlux = Flux.fromIterable(users);
                    return ServerResponse.ok().body(userFlux, User.class);
                });
    }
}
