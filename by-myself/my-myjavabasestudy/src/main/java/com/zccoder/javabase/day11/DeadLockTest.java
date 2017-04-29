package com.zccoder.javabase.day11;
//要求重点掌握

class TestDeadLockTest implements Runnable
{
    private boolean flag;
    TestDeadLockTest(boolean flag)
    {
        this.flag=flag;
    }
    public void run()
    {
        if(flag)
        {
            synchronized(MyLock.locka)
            {
                System.out.println("if locka");
                synchronized(MyLock.lockb)
                {
                    System.out.println("if lockb");
                }
            }
        }
        else
        {
            synchronized(MyLock.lockb)
            {
                System.out.println("else lockb");
                synchronized(MyLock.locka)
                {
                    System.out.println("else locka");
                }
            }
        }
    }
}
class MyLock
{
    static Object locka=new Object();
    static Object lockb=new Object();
}
public class  DeadLockTest
{
    public static void main(String[] args) 
    {
        Thread t1=new Thread(new TestDeadLockTest(true));
        Thread t2=new Thread(new TestDeadLockTest(false));
        t1.start();
        t2.start();
    }
}
