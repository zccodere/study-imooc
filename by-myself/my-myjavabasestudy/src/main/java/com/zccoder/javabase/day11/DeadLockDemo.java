package com.zccoder.javabase.day11;
/*
死锁：
同步中嵌套同步。而锁却不同。
*/
class TicketDeadLockDemo implements Runnable
{
    private int tick=1000;
    Object obj=new Object();
    boolean flag=true;
    public void run()
    {
        if(flag)
        {
            while(true)
            {
                synchronized(obj)
                {
                    show();
                }
            }
        }
        else
            while(true)
            show();
    }
    public synchronized void show()//this
    {

        synchronized(obj)
        {
            if(tick>0)
            {
                try{Thread.sleep(10);}catch (Exception e){}
                System.out.println(Thread.currentThread().getName()+"....code："+tick--);
            }
        }
    }
}
public class DeadLockDemo 
{
    public static void main(String[] args) 
    {
        TicketDeadLockDemo t=new TicketDeadLockDemo();
        Thread t1=new Thread(t);
        Thread t2=new Thread(t);
        t1.start();
        try{Thread.sleep(10);}catch(Exception e){}
        t.flag=false;
        t2.start();
        

    }
}
