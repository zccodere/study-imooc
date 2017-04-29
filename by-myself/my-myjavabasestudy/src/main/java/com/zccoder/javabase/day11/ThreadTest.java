package com.zccoder.javabase.day11;
/*
练习：
创建两个线程，和主线程交替运行。

原来线程都有自己默认的名称。Thread-编号。该编号从0开始。

static Thread currentThread()：获取当前线程对象。
getName()：获取线程名称。

设置线程名称：setName或者构造函数。
*/
class Test extends Thread
{
    //private String name;
    Test(String name)
    {
        //this.name=name;
        super(name);
    }
    public void run()
    {
        for(int x=0;x<60;x++)
        {
            System.out.println(Thread.currentThread().getName()+" run..."+x);
        }
    }
}
public class ThreadTest 
{
    public static void main(String[] args) 
    {
        Test t1=new Test("one--");
        Test t2=new Test("two++");
        t1.start();
        t2.start();
        //t1.run();
        //t2.run();
        for(int x=0;x<60;x++)
        {
            System.out.println("main......"+x);
        }
    }
}
