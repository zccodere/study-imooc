package com.zccoder.javabase.day09;
/*
因为项目中会出现特有的问题，
而这些问题并未被java所描述并封装对象。
所有对于这些特有的问题可以按照java的对问题封装的思想。
将特有的问题，进行自定义的异常封装。

自定义异常。

需求：在本程序中，对于除数是-1,也视为是错误的是无法进行运算的。
那么就需要对这个问题进行自定义的描述。

当在函数内部出现了throw抛出了异常对象，那么就必须要给对应的处理动作。
要么在内部try catch处理。
要么在函数上声明让调用者处理。

一般情况在，函数内部出现异常，函数上需要声明。

发现打印的结果中只有异常的名称，却没有异常的信息。
因为自定义的异常并未自定义信息。

如何定义异常信息呢？
因为父类中已经把异常信息的操作都完成了。
所有子类只要在构造时，将异常信息传递给父类通过super语句。
那么就可以直接通过getMessage方法获取自定义的异常信息。

自定义异常：必须是自定义类继承Exception。

继承Exception原因：异常体系有一个特点：因为异常类和异常对象都被抛出。
他们都具备可抛性。这个可抛性是Throwable这个体系中独有特点。

只有这个体系中的类和对象才可以被throws和throw操作。

throws和throw的区别：
throws使用在函数上。throw使用在函数内。
throws后面跟的异常类。可以跟多个。用逗号隔开。throw后跟的是异常对象。
*/
@SuppressWarnings("serial")
class FuShuException extends Exception//getMessage();
{
    private int value;
    FuShuException()
    {
        super();
    }
    FuShuException(String msg,int value)
    {
        super(msg);
        this.value=value;
    }
    public int getValue()
    {
        return value;
    }
}
class Demo3
{
    int div(int a,int b)throws FuShuException
    {
        if(b<0)
            throw new FuShuException("出现了除数是负数的情况 / by fushu",b);//手动通过throw关键字抛出一个自定义异常对象。
        return a/b;
    }
}
public class ExceptionDemo3
{
    public static void main(String[] args) 
    {
        Demo3 d=new Demo3();
        try
        {
            int x=d.div(4,-9);        
            System.out.println("x="+x);
        }
        catch (FuShuException e)
        {
            System.out.println(e.toString());
            //System.out.println("除数出现负数");
            System.out.println("错误的负数是："+e.getValue());

        }
        System.out.println("over");

    }
}
/*
class Throwable
{
    private String message;
    Throwable(String message)
    {
        this.message=message;
    }
    public String getMessage()
    {
        return message;
    }
}
class Exception extends Throwable
{
    Exception(String message)
    {
        super(message);
    }
}
*/
