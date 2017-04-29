package com.zccoder.javabase.day05;
/*
this：看上去，是用于区分局部变量和成员变量同名情况。
this为什么可以解决这个问题？
this到底代表的是什么呢？

this的特点：就代表本类的对象，到底代表哪一个呢？
    this代表它所在函数所属对象的引用。
    简单说：哪个对象在调用this所在的函数，this就代表哪个对象。
this的应用：当定义类中功能时，该函数内部要用到该函数的对象时，这时用this来表示这个对象。
            但凡本类功能内部使用到了本类对象，都用this代替。

*/
class Person
{
    private String name;
    private int age;
    Person(int age)
    {
        this.age=age;
    }
    Person(String name)
    {
        this.name=name;
    }
    Person(String name,int age)
    {
        this.name=name;
        this.age=age;
    }
    public void speak()
    {
        System.out.println("name="+this.name+"...age="+this.age);
        this.show();
    }
    public void show()
    {
        System.out.println(this.name);
    }
    /*
    需求：给人定义一个用于比较年龄是否相同的功能，也就是是否是同龄人。
    */
    public boolean compare(Person p)
    {
        return this.age==p.age;
    }
}
public class PersonDemo3 
{
    public static void main(String[] args) 
    {
        Person p1=new Person(20);
        Person p2=new Person(25);
        boolean b=p1.compare(p2);
        System.out.println(b);

        //Person p=new Person("lisi");
        //Person p1=new Person("zhangsan");
        //p.speak();
    }
}
