package com.myimooc.spring.ioc.interfaces;


public class Main {

    public static void main(String[] args) {
        OneInterface oif = (OneInterface) new OneInterfacesImpl();
        System.out.println(((OneInterfacesImpl) oif).hello("word"));
    }

}
