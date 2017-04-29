package com.zccoder.javabase.day09;
/*
毕老师用电脑上课。

开始思考上课中出现的问题。

比如问题是：
      电脑蓝屏。
      电脑冒烟。
要对问题进行描述，封装成对象。

可是当冒烟发生后，出现讲课进度无法继续。
出现了讲师的问题：课时计划无法完成。
*/

@SuppressWarnings("serial")
class LanPingException extends Exception
{
    LanPingException(String message)
    {
        super(message);
    }
}
@SuppressWarnings("serial")
class MaoYanException extends Exception
{
    MaoYanException(String message)
    {
        super(message);
    }
}
@SuppressWarnings("serial")
class NoPlanException extends Exception
{
    NoPlanException(String msg)
    {
        super(msg);
    }
}
class Computer
{
    private int state=3;
    public void run()throws LanPingException,MaoYanException
    {
        if(state==2)
            throw new LanPingException("蓝屏了");
        if(state==3)
            throw new MaoYanException("冒烟了");
        System.out.println("电脑运行");
    }
    public void reset()
    {
        state=1;
        System.out.println("电脑重启");
    }
}
class Teacher
{
    @SuppressWarnings("unused")
    private String name;
    private Computer cmpt;
    Teacher(String name)
    {
        this.name=name;
        cmpt=new Computer();
    }
    public void prelect()throws NoPlanException
    {
        try
        {
            cmpt.run();            
        }
        catch (LanPingException e)
        {
            cmpt.reset();
        }
        catch(MaoYanException e)
        {
            test();
            throw new NoPlanException("课时无法继续"+e.getMessage());            
        }
        System.out.println("讲课");
    }
    public void test()
    {
        System.out.println("练习");
    }
}
public class ExceptionTest
{
    public static void main(String[] args)
    {
        Teacher t=new Teacher("毕老师");
        try
        {
            t.prelect();
        }
        catch (NoPlanException e)
        {
            System.out.println(e.toString());
            System.out.println("换老师或者放假");
        }
        
    }
}
