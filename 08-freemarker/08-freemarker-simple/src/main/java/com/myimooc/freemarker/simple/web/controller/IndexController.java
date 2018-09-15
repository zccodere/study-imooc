package com.myimooc.freemarker.simple.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.myimooc.freemarker.simple.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 首页控制器
 * @author ZhangCheng
 * @date 2017-03-19
 * @version V1.0
 */
@Controller
@RequestMapping("/")
public class IndexController {
    
    private final static Logger LOGGER = LoggerFactory.getLogger(IndexController.class);
    
    /**
     * 跳转到首页
     * @return
     */
    @GetMapping(value={"","/index"})
    public ModelAndView doIndex(){
        LOGGER.info("doIndex methed is run!");
        
        ModelAndView mv = new ModelAndView("/index");
        mv.addObject("username","你好，Freemarker！");
        mv.addObject("userList",this.prepareUserList());
        return mv;
    }
    
    /**
     * 准备用户数据
     * @return 用户数据
     */
    private List<User> prepareUserList(){
        List<User> list = new ArrayList<User>();
        int count = 5;
        for(int i=0;i<count;i++){
            User item = new User();
            item.setName("用户"+i);
            item.setBirthday(new Date());
            list.add(item);
        }
        return list;
    }
    
}
