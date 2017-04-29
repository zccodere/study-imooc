package com.zccoder.javabase.day12;
public class ThreadTest 
{
    public static void main(String[] args) 
    {
        new Thread()
        {
            public void run()
            {
                for(int x=0;x<100;x++)
                {
                    System.out.println(Thread.currentThread().getName()+"......"+x);
                }
            }
        }.start();
        
        for(int x=0;x<100;x++)
        {
            System.out.println(Thread.currentThread().getName()+"......"+x);
        }
//        Runnable r=new Runnable{
//            public void run()
//            {
//                for(int x=0;x<100;x++)
//                {
//                    System.out.println(Thread.currentThread().getName()+"......"+x);
//                }
//            }
//        };
//        new Thread(r).start();
        
        //new Test1().start();
    }
}
/*
class Test1 extends Thread
{
    public void run()
    {
        for(int x=0;x<100;x++)
            {
                System.out.println(Thread.currentThread().getName()+"......"+x);
            }
    }
}
*/
