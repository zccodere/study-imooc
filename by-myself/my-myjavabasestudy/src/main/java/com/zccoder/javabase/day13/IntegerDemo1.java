package com.zccoder.javabase.day13;
/*
JDK1.5版本以后出现的新特性。
*/

public class  IntegerDemo1
{
    public static void main(String[] args) 
    {
        //Integer x = new Integer(4);    

        Integer x=4;//自动装箱。//new Integer(4)。

        x=x/*x.intValue()*/+2;//x+2:x进行了自动拆箱。变成了int类型。和2进行加法运算。
              //再将和进行装箱赋给x。

        Integer m=128;
        Integer n=128;
        sop("m==n："+(m==n));

        Integer a=127;
        Integer b=127;
        sop("a==b："+(a==b));//结果true。因为a和b指向了同一个Integer对象。
                             //因为当数值在byte范围内容，对于新特性，如果该数组已经存在，则不会再开辟新的空间。
    }
    public static void method()
    {
        Integer x = new Integer("123");

        Integer y = new Integer(123);

        sop("x==y:"+(x==y));
        sop("x.equals(y):"+x.equals(y));
    }
    public static void sop(String str)
    {
        System.out.println(str);
    }
}
