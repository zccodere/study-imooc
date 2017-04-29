package com.zccoder.javabase.day07;
/*
需求：获取一段程序运行的时间。
原理：获取程序开始和结束的时间并相减即可。

获取时间：System.currentTimeMillis();

当代码完成优化后，就可以解决这类问题。

这种方式，模板方法设计模式。

什么是模板方法呢？
在定义功能时，功能的一部分是确定的，但是有一部分是不确定，而确定的部分在使用不确定的部分。
那么这时就将不确定的部分暴露出去。由该类的子类去实现。
*/
abstract class GetTime
{
    public final void getTime()
    {
        long start=System.currentTimeMillis();
        runcode();
        long end=System.currentTimeMillis();
        System.out.println("毫秒："+(end-start));
    }
    public abstract void runcode();
}
class SubTime extends GetTime
{
    public void runcode()
    {
        
        for(int x=0;x<4000;x++)
        {
            System.out.print(x);
        }
    }
}
public class TemplateDemo
{
    public static void main(String[] args) 
    {
        //GetTime gt=new GetTime();
        SubTime gt=new SubTime();
        gt.getTime();
    }
}
