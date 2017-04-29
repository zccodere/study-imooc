package com.zccoder.javabase.day07;
/*
当多个类中出现相同功能，但是功能主体不同，
这时也可以进行向上抽取。这时，只抽取功能定义，而不抽取功能主体。


抽象：看不懂。

抽象类的特点：
A，抽象方法一定定义在抽象类中。
B，抽象方法和抽象类都必须被abstract关键字修饰。
C，抽象类不可以被new创建对象。因为调用抽象方法没意义。
D，抽象类中的抽象方法要被使用，必须由子类复写其所有的抽象方法后，建立子类对象调用。
    如果子类只覆盖了部分抽象方法，那么该子类还是一个抽象类。

抽象类和一般类没有太大的不同。
该如何描述事物，就如何描述事物，只不过，该事物中出现了一些看不懂的东西。
这些不确定的部分，也是该事物的功能，需要明确出现，但是无法定义主体。
通过抽象方法来表示。

抽象类比一般类多了抽象方法（函数）。就是在类中可以定义抽象方法。
抽象类不可以实例化（即不可以new）。

特殊：抽象类中可以不定义抽象方法，这样做仅仅是不让该类建立对象。
*/
abstract class Student1
{
    abstract void study();
    //abstract void study1();
    void sleep()
    {
        System.out.println("躺着");
    }
}
class ChongCiStudent extends Student1
{
    void study()
    {
        System.out.println("chongci study");
    }
}
class BaseStudent extends Student1
{
    void study()
    {
        System.out.println("base study");
    }
}
class AdvStudent extends Student1
{
    void study()
    {
        System.out.println("adv study");
    }
}

public class AbstractDemo 
{
    public static void main(String[] args) 
    {
        new BaseStudent().study();
    }
}
