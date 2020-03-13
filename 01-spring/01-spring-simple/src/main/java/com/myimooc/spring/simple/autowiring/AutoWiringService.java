package com.myimooc.spring.simple.autowiring;

/**
 * 服务
 *
 * @author zc 2017-01-18
 */
public class AutoWiringService {

    private AutoWiringDao autoWiringDAO;

    public AutoWiringService(AutoWiringDao autoWiringDAO) {
        System.out.println("AutoWiringService");
        this.autoWiringDAO = autoWiringDAO;
    }

    public void setAutoWiringDAO(AutoWiringDao autoWiringDAO) {
        System.out.println("setAutoWiringDAO");
        this.autoWiringDAO = autoWiringDAO;
    }

    public void say(String word) {
        this.autoWiringDAO.say(word);
    }

}
