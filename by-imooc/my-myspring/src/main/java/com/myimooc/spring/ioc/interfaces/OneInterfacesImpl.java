package com.myimooc.spring.ioc.interfaces;

public class OneInterfacesImpl implements OneInterface {

    public String hello(String word) {
        return "Word form interfaces\"OneInterface\":"+word;
    }

    @Override
    public void say(String arg) {
        // TODO Auto-generated method stub
        
    }

}
