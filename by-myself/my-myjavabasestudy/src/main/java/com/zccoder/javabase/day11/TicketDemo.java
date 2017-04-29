package com.zccoder.javabase.day11;
/*
需求：简单的卖票程序。
多个窗口卖票。

创建线程的第二种方式：实现Runnable接口。
步骤：
1，定义类实现Runnable接口。
2，覆盖Runnable接口中的run方法。目的：将线程要运行的代码存放在run方法中。
3，通过Thread类建立线程对象。
4，将Runnable接口的子类对象作为实际参数传递给Thread类的构造函数。
    卫生了要将Runnable接口的子类对象传递给Thread的构造函数。
    因为，自定义的run方法所属的对象时Runnable接口的子类对象。
    所有要让线程去指定指定对象的run方法。就必须明确该run方法所属对象。
5，调用Thread类的start方法开启线程并调用Runnable接口子类的run方法。

实现方式和基础方法有什么区别呢？

实现方式好处：避免了单继承的局限性。在定义线程时，建议使用实现方式。

两种方式区别：
继承Thread：线程代码存放在Thread子类run方法中。
实现Runnable：线程代码存放在接口的子类的run方法中。
*/
class TicketTicketDemo implements Runnable//extends Thread
{
    private int tick=100;
    public void run()
    {
        while(true)
        {
            if(tick>0)
            {
                System.out.println(Thread.currentThread().getName()+"sale："+tick--);
            }
        }
    }
}
public class TicketDemo 
{
    public static void main(String[] args) 
    {
        TicketTicketDemo t=new TicketTicketDemo();
        Thread t1=new Thread(t);//创建了一个线程；
        Thread t2=new Thread(t);//创建了一个线程；
        Thread t3=new Thread(t);//创建了一个线程；
        Thread t4=new Thread(t);//创建了一个线程；
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        //Ticket t1=new Ticket();
        //Ticket t2=new Ticket();
        //Ticket t3=new Ticket();
        //Ticket t4=new Ticket();

        //t1.start();
        //t1.start();
        //t1.start();
        //t1.start();
    }
}
