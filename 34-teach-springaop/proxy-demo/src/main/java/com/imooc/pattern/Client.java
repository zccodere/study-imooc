package com.imooc.pattern;

/**
 * Created by cat on 2017-02-27.
 */
public class Client {

    public static void main(String[] args){
        Subject subject = new Proxy(new RealSubject());
        subject.request();
    }
}
