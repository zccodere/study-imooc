package com.zccoder.javabase.day03;
//语句嵌套形式，其实就是语句中含有语句。
//循环嵌套。
public class ForForDemo 
{
    public static void main(String[] args) 
    {
        for(int x=0;x<3;x++)
        {
            for(int y=0;y<4;y++)
            {
                System.out.print("*");
            }
            System.out.println();//只有一个功能就是换行。
        }
        /*
        ****
        ****
        ****
        对于打印长方形：
        外循环控制的行数。
        内循环控制的是每一行的列数。也就是一行中元素的个数。
        */
        
        System.out.println("-------------------------------------");
        
        /*
        *****
        ****
        ***
        **
        *
        发现图形有很多行，每一行有很多列。
        要使用嵌套循环。原理：形象说法：大圈套小圈。
        */
        for(int x=0;x<5;x++)//x<5:因为外循环控制行数。一共5行。
        {
            for(int y=x;y<5;y++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
