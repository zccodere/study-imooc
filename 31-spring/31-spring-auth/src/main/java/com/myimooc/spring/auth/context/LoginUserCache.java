package com.myimooc.spring.auth.context;

import com.myimooc.spring.auth.dto.Accordion;
import com.myimooc.spring.auth.entity.User;

import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;

/**
 * 用户登录缓存服务
 *
 * @author zc 2017-08-20
 */
@Service
public class LoginUserCache {

    /**
     * 使用cookie
     */
    private static Map<String, User> cache = new HashMap<>(16);
    private static Map<String, List<Accordion>> userAccordionMap = new HashMap<>(16);

    public static void put(User user) {
        cache.put(user.getName(), user);
        UserContext.setCurrent(user);
        setCookie(user);
    }

    public static User get(String username) {
        return cache.get(username);
    }

    public static void setCookie(User user) {
        // 过期时间（单位：秒）
        int expire = 1800;
        String source = user.getName() + "$" + user.getPwd();
        byte[] result = Base64.getEncoder().encode(source.getBytes());
        Cookie cookie = new Cookie("auth", new String(result));
        cookie.setMaxAge(expire);
        ResponseContext.getCurrent().addCookie(cookie);
    }

    public static void remove(String username) {
        cache.remove(username);
        Cookie cookie = new Cookie("auth", null);
        ResponseContext.getCurrent().addCookie(cookie);
        UserContext.setCurrent(null);
    }

    public static void setAccordions(String username, List<Accordion> accordions) {
        userAccordionMap.put(username, accordions);
    }

    public static List<Accordion> getAccordions(String username) {
        return userAccordionMap.get(username);
    }
	
	
	
/*	
   本地缓存方式
   private static Map<Long,LoginUser> cache = new HashMap<Long,LoginUser>();
	
	*//**
     *
     * @param user
     * @param expire 单位秒，如果是30分钟过期，即：60*30 = 1800
     *//*
	public static void put(User user,long expire){
		long expireTime = Calendar.getInstance().getTime().getTime()+expire*1000;
		LoginUser loginUser = new LoginUser();
		loginUser.setUser(user);
		loginUser.setExpire(expireTime);
		cache.put(user.getId(), loginUser);
	}
	
	public static void remove(){
		
	}
	
	@SuppressWarnings("unused")
	private static class LoginUser{
		private Long expire;
		private User user;
		public Long getExpire() {
			return expire;
		}
		public void setExpire(Long expire) {
			this.expire = expire;
		}
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
	}*/
}
