package com.zccoder.javabase.day03;
/*
需求：
1，定义一个功能，用于打印矩形。
2，定义一个打印99乘法表功能的函数。
*/
public class FunctionTest 
{
    public static void main(String[] args) 
    {
        /*
        draw(5,6);
        printhr();
        draw(7,8);
        printhr();
        */
        print99();
    }
    //方法一：ZC
    /*
    题1：
    public static void printjx(int a,int b)
    {
        for(int x=1;x<=a;x++)
        {
            for(int y=1;y<=b;y++)
            {
                System.out.print("*");

            }
            System.out.println();
        }
    }
    题2：
    public static void printcfb()
    {
        for(int x=1;x<=9;x++)
        {
            for(int y=1;y<=x;y++)
            {
                System.out.print(y+"*"+x+"="+y*x+"\t");
            }
            System.out.println();
        }
    }
    */
    //方法二：TC
    /*
    题1：
    定义一个功能，用于打印矩形。
    思路：
    1,确定结果：没有，因为直接打印，所以返回值类型是void。
    2，有位置内容？有，两个，因为矩形的行和列不确定。
    */
    public static void draw(int row,int col)
    {
        for(int x=0;x<row;x++)
        {
            for(int y=0;y<col;y++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void printhr()
    {
        System.out.println("----------------------------------------");
    }
    /*
    题2：
    定义一个打印99乘法表功能的函数。
    */
    public static void print99()
    {
        for(int x=1;x<=9;x++)
        {
            for(int y=1;y<=x;y++)
            {
                System.out.print(y+"*"+x+"="+y*x+"\t");
            }
            System.out.println();
        }
    }
}
