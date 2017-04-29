package com.zccoder.javabase.day07;
/*
3、子父类中的构造函数。
发现在对子类对象进行初始化时，父类的构造函数也会运行。
那是因为子类的构造函数默认第一行有一条隐式的语句super（）；
super（）；会访问父类中空参数的构造函数。而且子类中所有的构造函数默认第一行都是super（）；

为什么子类一定要访问父类中的构造函数：
因为父类中的数据子类可以直接获取，所有之类对象在建立时，需要先查看父类是如何对这些数据进行初始化的。
所有之类在对象初始化时，要先访问一下父类中的构造函数。
如果要访问父类中指定的构造函数，可以通过手动定义super语句的方式来指定。

注意：super语句一定一定在子类构造函数第一行。


子类的实例化过程。
结论：
子类的所有的构造函数默认都会访问父类中空参数的构造函数。
因为子类每一个构造函数内的每一行都有一句隐式的super（）；

当父类中没有空参数的构造函数时，子类必须手动通过super语句或者this语句形式来指定要访问父类中的构造函数。

当然：子类的构造函数第一行也可以收到指定this语句来访问本类中的构造函数。子类中至少会有一个构造函数会访问父类中的构造函数。
*/
class Fu1//extends object
{
    int num;
    Fu1()
    {
        num=60;
        System.out.println("fu run");
    }
    Fu1(int x)
    {
        System.out.println("fu ..."+x);
    }
}
class Zi1 extends Fu1
{
    Zi1()
    {
        //super();
        System.out.println("zi run");
    }
    Zi1(int x)
    {
        //super();
        System.out.println("zi..."+x);
    }
}
public class ExtendsDemo4 
{
    public static void main(String[] args) 
    {
        Zi1 z=new Zi1();
        System.out.println(z.num);
    }
}

/*
class Person
{
    private String name;
    Persong(String name)
    {
        this.name=name;
    }
    void show(){}
}
class Student extends Person
{
    Student(String name);
    {
        super(name);
    }
    void method()
    {
        super.show();
    }
}
*/
