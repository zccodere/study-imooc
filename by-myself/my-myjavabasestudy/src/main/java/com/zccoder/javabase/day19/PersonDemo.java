package com.zccoder.javabase.day19;
/*
装饰设计模式：
当想要对已有的对象进行功能增强时，
可以定义类，将已有对象传入，基于已有的功能，并提供加强功能。
那么自定义的该类称为装饰类。

装饰类通常会通过构造方法接收被装饰的对象。
并基于被装饰的对象的功能，提供更强的功能。
*/
class Person
{
    public void chifan()
    {
        System.out.println("吃饭");
    }
}
class SuperPerson
{
    private Person p;
    SuperPerson(Person p)
    {
        this.p=p;
    }
    public void superChifan()
    {
        System.out.println("开胃酒");
        p.chifan();
        System.out.println("甜点");
        System.out.println("来一根");
    }
}
public class PersonDemo 
{
    public static void main(String[] args) 
    {
        Person p = new Person();
        
        //p.chifan();

        SuperPerson sp = new SuperPerson(p);
        sp.superChifan();
    }
}
