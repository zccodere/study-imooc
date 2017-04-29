package com.zccoder.javabase.day01;

public class test        //Java定义类+类名（首字母大写）
{
    public static void main(String[] args)        //主函数（保证类的独立运行）
    {
        System.out.println("hello world");    //输出打印语句
    }
}
class testTwo
{        //按需使用主函数
    {
        System.out.println("hello world test");    //输出打印语句
    }
}
//java三种注释方式
//单行注释（可用于调试程序）
///*多行注释*/（不允许嵌套）
/**java注释，可提取出生成文档说明书*/
//标准化编程：
/*
需求：定义一个Hello World小程序。

思路：
1，
2，

步骤：
1,通过class关键字定义一个类。将代码都编写到该类中。
2，为了保证该的独立运行。在类中定义个主函数。格式public static void main(String[] args)
3，保存成一个扩展名为java的文件。
4，在dos控制台中通过javac工具对java文件进行编译。
5，在通过java命令对生成的class文件进行执行。

版本：v1.0

日期：2016.01.06

作者：ZC

copyright：ZC
*/