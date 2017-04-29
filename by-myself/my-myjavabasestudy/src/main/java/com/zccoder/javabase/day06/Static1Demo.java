package com.zccoder.javabase.day06;
/*
什么时候使用静态？
要从两方面下手：
因为静态修饰的内容有成员变量和函数。
什么时候定义静态变量（类变量）呢？
当对象中出现共享数据时，该数据静态所修饰。
对象中的特有数据要定义成非静态存在于堆内存中。

什么时候定义静态函数呢？
当功能内部没有访问到非静态数据（对象的特有数据），
那么该功能可以定义成静态的。
*/
class Static1Person
{
    String name;
    public void show()
    {
        System.out.println("name+haha");
    }
}
public class Static1Demo
{
    public static void main(String[] args) 
    {
        Static1Person p=new Static1Person();
        p.show();
    }
}
