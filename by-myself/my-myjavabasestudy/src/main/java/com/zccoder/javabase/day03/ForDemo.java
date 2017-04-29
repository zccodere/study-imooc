package com.zccoder.javabase.day03;

public class ForDemo 
{
    public static void main(String[] args) 
    {
        /*
        for（初始化表达式；循环条件表达式；循环后的操作表达式）
        {
            执行语句；
        }
        */
        for(int x=0;x<3;x++)
        {
            System.out.println("x="+x);
        }
        int y=0;
        while(y<3)
        {
            System.out.println("y="+y);
            y++;
        }
        /*
        1、变量有自己的作用域。对于一个变量来将，如果这个变量仅仅用于控制循环的次数，
        用作循环增量时用for语句。循环结束时，该变量在内存被释放。用于优化内存。
        2、for和while可以进行互换，如果定义循环增量，用for更为合适。

        总结：什么时候使用循环结构？
        当要多某些语句执行很多次时，就是用循环结构。
        */
    }
}
