package com.zccoder.javabase.day09;
/*
匿名内部类：
1，匿名内部类其实就是内部类的简写格式。
2，定义匿名内部类的前提：内部类必须继承一个类或者实现接口。
3，匿名内部类的格式：new 父类或者接口（）{定义子类的内容}。
4，其实匿名内部类就是一个匿名子类对象。而且这个对象有点胖。可以理解为带内容的对象。
5，匿名内部类中定义的方法最好不要超过3个。
*/
abstract class AbsDemo
{
    abstract void show();
}
class Outer4
{
    int x=3;
    /*
    class Inner extends AbsDemo
    {
        void show()
        {
            System.out.println("show:"+x);
        }
    }
    */
    public void function()
    {
        new AbsDemo()
        {
            void show()
            {
                System.out.println("x="+x);
            }
            @SuppressWarnings("unused")
            void abc()
            {
                System.out.println("haha");
            }
        }.show();
    }
}
public class  InnerClassDemo4
{
    public static void main(String[] args) 
    {
        new Outer4().function();
    }
}
