package com.zccoder.javabase.day05;
/*
this语句：用于构造函数之间函数互相调用。

this语句：只能定义在构造函数的第一行。因为初始化要先执行。
*/
class Person3
{
    @SuppressWarnings("unused")
    private String name;
    @SuppressWarnings("unused")
    private int age;
    Person3(String name)
    {
        this.name=name;
    }
    Person3(String name,int age)
    {
        //this.name=name;
        this(name);//p(name);
        this.age=age;
    }
}
public class PersonDemo4 
{
    @SuppressWarnings("unused")
    public static void main(String[] args) 
    {
        Person3 p=new Person3("lisi",30);
        Person3 p1=new Person3("lisi2",36);
    }
}
