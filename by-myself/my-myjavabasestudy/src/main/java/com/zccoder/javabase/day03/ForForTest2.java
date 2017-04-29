package com.zccoder.javabase.day03;
/*
循环嵌套练习题：
----*
---* *
--* * *
-* * * *
* * * * *
*/

public class ForForTest2 
{
    public static void main(String[] args) 
    {
        //方法一：ZC
        /*
        for(int x=1;x<=5;x++)
        {
            for(int y=x;y<5;y++)
            {
                System.out.print("-");
            }
            for(int z=1;z<=x;z++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
        */
        //方法二：TC
        for(int x=0;x<5;x++)
        {
            for(int y=x;y<4;y++)
            {
                System.out.print("-");
            }
            for(int z=0;z<=x;z++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
