package com.zccoder.javabase.day10;
/*
异常：
是什么？是对问题的描述，将问题进行对象的封装。
-------------------
异常体系：
Throwable
    |--Error
    |--Exception
        |--RuntimeException

异常体系的特点：异常体系中的所有类以及建立的对象都具备可抛性。
                也就是说可以被throw和throws关键字所操作。
                只有异常体系具备这个特点。
-----------------------            
throw和throws的用法：
throw定义在函数内，用于抛出异常对象。
throws定义在函数上，用于抛出异常类，可以抛出多个用逗号隔开。

当函数内容有throw抛出异常对象，并未进行try处理。必须要在函数上声明，都在编译失败。
注意：RuntimeException除外。也就是说，函数内如果抛出的RuntimeException异常，函数上可以不用声明。
-----------------------    
如果函数声明了异常，调用者需要进行处理。处理方法可以throws和try。

异常有两种：
    编译时被检测异常
        该异常在编译时，如果没有处理（没有抛也没有try），编译失败。
        该异常被标识，代表着可以被处理。
    运行时异常（编译时不检测）
        在编译时，不需要处理，编译器不检查。
        该异常的发生，建立不处理，让程序停止。需要对代码进行修正。
-----------------------    
异常处理语句：try（需要被检测的代码；） catch（处理异常的代码；） finally（一定会执行的代码；）。
有三种结合格式：try catch；try finally；try catch finally。
注意：
A，finally中定义的通常是关闭资源代码。因为资源必须释放。
B，finally只有一种情况不会执行。当执行到System.exit(0);finally不会执行。
-----------------------    
自定义异常：
    定义类继续Exception或者RuntimeException。
    A，为了让该自定义类具备可抛性。
    B，让该类具备操作异常的共性方法。

    当要定义自定义异常的信息时，可以使用父类已经定义好的功能。
    异常异常信息传递给父类的构成函数。
    class MyException extends Exception
    {
        MyException(String message)
        {
            super(message);
        }
    }

自定义异常：按照java的面向对象思想，将程序中出现的特有问题进行封装。
-----------------------    
异常的好处：
    A，将问题进行封装。
    B，将正常流程代码和问题处理代码相分离，方便于阅读。

异常的处理原则：
    A，处理方式有两种：try或者throws。
    B，调用到抛出异常的功能时，抛出几个，就处理几个。
        一个try对应多个catch。
    C，多个catch，父类的catch放到最下面。
    D，catch内需要定义针对性的处理方式。不要简单的定义printStackTrace,输出语句。
        也不要不写。
        当捕获到的异常，本功能处理不了时，可以继续在catch中抛出。
        try
        {
            throw new AException();
        }
        catch (AException e)
        {
            throw e;
        }

        如果该异常处理不了，当并不属于该功能出现的异常。
        可以将异常转换后，在抛出和该功能相关的异常。

        或者异常可以处理，当需要将异常产生的和本功能相关的问题提供出去，
        当调用者知道。并处理。也可以将捕获异常处理后，转换新的异常。
        try
        {
            throw new AException();
        }
        catch (AException e)
        {
            //对AException处理。
            throw new BException();
        }

异常的注意事项：
    在子父类覆盖时：
        A，子类抛出的异常必须是父类异常的子类或者子集。
        B，如果父类或者接口没有异常抛出时，子类覆盖出现异常，只能try不能抛。



参阅
ExceptionTest.java 老师用电脑上课。
ExceptionTest1.java 图形面积。
*/
class SDS
{
    public static void main(String[] args) 
    {
        System.out.println("Hello World!");
    }
}
