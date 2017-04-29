package com.zccoder.javabase.day08;
/*
基础班学生：
    学习，睡觉。
高级版学生：
    学习，睡觉。

可以将这两类事物进行抽取。
*/

abstract class Student
{
    public abstract void study();
    public void sleep()
    {
        System.out.println("躺着睡");
    }
}
class BaseStudent extends Student
{
    public void study()
    {
        System.out.println("base study");
    }
    public void sleep()
    {
        System.out.println("坐着睡");
    }
}
class AdvStudent extends Student
{
    public void study()
    {
        System.out.println("adv study");
    }
}
class DoStudent
{
    public void doSome(Student stu)
    {
        stu.study();
        stu.sleep();
    }
}

public class  DuoTaiDemo3
{
    public static void main(String[] args) 
    {
        DoStudent ds=new DoStudent();
        ds.doSome(new BaseStudent());
        ds.doSome(new AdvStudent());
        //BaseStudent bs=new BaseStudent();
        //bs.study();
        //bs.sleep();
        //AdvStudent as=new AdvStudent();
        //as.study();
        //as.sleep();
    }
}
