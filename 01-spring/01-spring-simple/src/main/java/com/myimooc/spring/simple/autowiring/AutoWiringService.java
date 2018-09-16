package com.myimooc.spring.simple.autowiring;

/**
 * <br>
 * 标题: 服务<br>
 * 描述: 服务<br>
 * 时间: 2017/01/18<br>
 *
 * @author zc
 */
public class AutoWiringService {

    private AutoWiringDAO autoWiringDAO;

    public AutoWiringService(AutoWiringDAO autoWiringDAO) {
        System.out.println("AutoWiringService");
        this.autoWiringDAO = autoWiringDAO;
    }

    public void setAutoWiringDAO(AutoWiringDAO autoWiringDAO) {
        System.out.println("setAutoWiringDAO");
        this.autoWiringDAO = autoWiringDAO;
    }

    public void say(String word) {
        this.autoWiringDAO.say(word);
    }

}
