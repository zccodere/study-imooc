package com.zccoder.javabase.day03;
public class ForTest 
{
    public static void main(String[] args) 
    {
        int x=1;
        for(System.out.println("a");x<3;System.out.println("c"),x++)
        {
            System.out.println("d");
            //x++;
        }
        //输出结果：adcdc
        for(int y=0;y<3;y++)
        {
        }
        /*
        无限循环的最简单表现形式。
        for（；；）{}
        while（true）{}
        */
    }
}
