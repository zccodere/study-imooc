package com.zccoder.javabase.day12;
/*
对于多个生成者和消费者。
为什么要定义while判断标记？
原因：让被唤醒的线程再一次判断标记。

为什么定义notifyAll？因为需要唤醒对方线程。
因为只用notify，容易出现只唤醒本方线程的情况。导致程序中的所有线程都等待。
*/
public class ProducerConsumerDemo 
{
    public static void main(String[] args) 
    {
        Resource r=new Resource();
        Producer pro=new Producer(r);
        Consumer con=new Consumer(r);

        Thread t1=new Thread(pro);
        Thread t2=new Thread(pro);
        Thread t3=new Thread(con);
        Thread t4=new Thread(con);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class ResourceProducerConsumerDemo
{
    private String name;
    private int count=1;
    private boolean flag=false;
    public synchronized void set(String name)
    {
        while(flag)
            try{this.wait();}catch(Exception e){}
        this.name=name+"--"+count++;
        System.out.println(Thread.currentThread().getName()+"...生产者..."+this.name);
        flag=true;
        this.notifyAll();

    }
    public synchronized void out()
    {
        while(!flag)
            try{this.wait();}catch(Exception e){}
        System.out.println(Thread.currentThread().getName()+"...消费者......"+this.name);
        flag=false;
        this.notifyAll();
    }
}

class ProducerProducerConsumerDemo implements Runnable
{
    private ResourceProducerConsumerDemo res;
    ProducerProducerConsumerDemo(ResourceProducerConsumerDemo res)
    {
        this.res=res;
    }
    public void run()
    {
        while(true)
        {
            res.set("+商品+");
        }
    }
}

class ConsumerProducerConsumerDemo implements Runnable
{
    private ResourceProducerConsumerDemo res;
    ConsumerProducerConsumerDemo(ResourceProducerConsumerDemo res)
    {
        this.res=res;
    }
    public void run()
    {
        while(true)
        {
            res.out();
        }
    }
}
