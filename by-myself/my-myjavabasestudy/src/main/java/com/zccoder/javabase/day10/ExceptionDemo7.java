package com.zccoder.javabase.day10;
/*
异常在子父类覆盖中的体现：
A，子类在覆盖父类时，如果父类的方法抛出异常，那么子类的覆盖方法，只能抛出父类的异常或者该异常的子类。
B，如果父类方法抛出多个异常，那么子类在覆盖该方法时，只能抛出父类异常的子集。
C，如果父类或者接口的方法中没有异常抛出，那么子类在覆盖方法时，也不可以抛出异常。
    如果子类方法发生了异常。就必须要进行try处理。绝对不能抛。
*/

@SuppressWarnings("serial")
class AException extends Exception
{
}
@SuppressWarnings("serial")
class BException extends AException
{
}
@SuppressWarnings("serial")
class CException extends Exception
{
}
/*
Exception
    |--AException
        |--BException
    |--CException
*/
//class Fu
//{
//    void show()throw AException
//    {
//    }
//}
//
//class Test
//{
//    void function(Fu f)
//    {
//        try
//        {
//            f.show();
//        }
//        catch (AException e)
//        {
//        }
//        
//    }
//}
//
//
//
//
//
//class Zi extends Fu
//{
//    void show()throw BException
//    {
//    }
//}
//class  
//{
//    public static void main(String[] args) 
//    {
//        Test t=new Test();
//        t.function(new Fu(Zi));
//    }
//}
