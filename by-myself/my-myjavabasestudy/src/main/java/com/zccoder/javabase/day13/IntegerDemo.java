package com.zccoder.javabase.day13;
/*
基本数据类型对象包装类。
基本数    引用数
据类型    据类型（类）
byte    Byte
short    Short
int        Integer
long    Long
boolean    Boolean
float    Float
double    Double
char    Character

基本数据类型对象包装类的最常见作用：就是用于基本数据类型和字符串类型之间做转换。

基本数据类型转成字符串。
    基本数据类型+""
    基本数据类型.toString(基本数据类型值);
    如：Integer.toString(34);//将34整数变成"34"。

字符串转成基本数据类型。
    基本数据类型包装类.parseInt(字符串);
    如：xxx a=Xxx.parseXxx(String);
        int a=Integer.parseInt("123");
        double d=Double.parseDouble("12.23");
        boolean b=Boolean.parseBoolean("true");
        
        Integer i=new Integer("123");
        int num=i.intValue();

十进制转成其他进制。
    toBinaryString();
    toHexString();
    toOctalString();

其他进制转成十进制。
    parseInt(string,radix);
*/
public class IntegerDemo 
{
    public static void sop(String str)
    {
        System.out.println(str);
    }
    @SuppressWarnings("unused")
    public static void main(String[] args) 
    {
        //整数类型的最大值。
        //sop("int max：="+Integer.MAX_VALUE);

        //将一个字符串转成整数。
        int num=Integer.parseInt("123");//必须传入数组格式的字符串。
        //long x=Long.parseInt("123");
        //sop("num="+(num+4));

        //sop(Integer.toBinaryString(-6));
        //sop(Integer.toHexString(60));

        int x=Integer.parseInt("3c",16);
        sop("x="+x);
    }
}
