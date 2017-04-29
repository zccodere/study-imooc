package com.zccoder.javabase.day05;
/*
构造函数：
对象一建立就会调用与之对应的构造函数。
构造函数的作用：可以用于给对象进行初始化。

构造函数和一般函数在写法上有不同。
在运行上也有不同。
构造函数是在对象一建立就运行。就对象初始化。
而一般方法是对象调用才执行，是给对象添加对象具备的功能。

一个对象建立，构造函数只运行一次。
而一般方法可以被该对象调用多次。

什么时候定义构造函数呢？
当分析事物时，该事物存在具备一些特征或者行为，那么将这些内容定义在构造函数中。
*/
class Person2
{
    private String name;
    private int age;
    /*
    构造代码块。
    作用：给对象进行初始化。
    对象一建立就运行，而且优先于构造函数执行。

    和构造函数区别：
    构造代码块是给所有对象进行统一初始化，
    而构造函数是给对应的对象进行初始化。
    
    构造代码块中定义的是不同对象共性的初始化内容。
    */
    {
        //System.out.println("person code run");
//        cry();
    }
    Person2()
    {
        System.out.println("A:name="+name+",age="+age);
    }
    Person2(String n)
    {
        name=n;
        System.out.println("B:name="+name+",age="+age);
    }
    /*
    public void setName(String n)
    {
        name=n;
    }
    public String getName()
    {
        return name;
    }
    */
    Person2(String n,int a)
    {
        name=n;
        age=a;
        System.out.println("C:name="+name+",age="+age);
    }
    public void cay()
    {
        System.out.println("cry......");
    }
}
public class PersonDemo2 
{
    @SuppressWarnings("unused")
    public static void main(String[] args) 
    {
        Person2 p1=new Person2();
        //Person p2=new Person("lisi");
        //Person p3=new Person("wangu",10);
    }
}
