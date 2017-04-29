package com.zccoder.javabase.day11;
/*
同步函数用的是哪一个锁呢？
函数需要被对象调用。那么函数都有一个所属对象引用。就是this。
所有同步函数使用的锁是this。

通过该程序进行验证。

使用两个线程来卖票。
一个线程在同步代码块中。
一个线程在同步函数中。
都在执行买票动作。
*/
class TicketThisLockDemo implements Runnable
{
    private int tick=100;
    Object obj=new Object();
    boolean flag=true;
    public void run()
    {
        if(flag)
        {
            while(true)
            {
                synchronized(this)
                {
                    if(tick>0)
                    {
                        try{Thread.sleep(10);}catch (Exception e){}
                        System.out.println(Thread.currentThread().getName()+"....code："+tick--);
                    }
                }
            }
        }
        else
            while(true)
            show();
    }
    public synchronized void show()//this
    {
        if(tick>0)
        {
            try{Thread.sleep(10);}catch (Exception e){}
            System.out.println(Thread.currentThread().getName()+"....show....："+tick--);
        }
    }
}
public class ThisLockDemo 
{
    public static void main(String[] args) 
    {
        TicketThisLockDemo t=new TicketThisLockDemo();
        Thread t1=new Thread(t);//创建了一个线程；
        Thread t2=new Thread(t);//创建了一个线程；
        t1.start();
        try{Thread.sleep(10);}catch(Exception e){}
        t.flag=false;
        t2.start();
        
        
        
        //Thread t3=new Thread(t);//创建了一个线程；
        //Thread t4=new Thread(t);//创建了一个线程；
        //t1.start();
        //t2.start();
        //t3.start();
        //t4.start();
    }
}
