package com.zccoder.javabase.day18;
/*
练习：给定一个小数。
保留该小数的后两位。
*/
import java.util.*;
class MathDemo 
{
    public static void main(String[] args) 
    {
        Random r=new Random();
        for(int x=0;x<10;x++)
        {
        //    int d=(int)(Math.random()*10+1);
            int d=r.nextInt(10)+1;
            sop(d);
        }
        
    }
    public static void show()
    {
        double d=Math.ceil(16.34);//ceil返回大于指定数据的最小整数。
        double d1=Math.floor(12.34);//floor返回小于指定数据的最大整数。

        long l=Math.round(12.34);//四舍五入
        sop("d="+d);
        sop("d1="+d1);
        sop("l="+l);

        double d2=Math.pow(2,3);
        sop("d2="+d2);        
    }
    public static void sop(Object obj)
    {
        System.out.println(obj);
    }
}
