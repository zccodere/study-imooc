package com.zccoder.javabase.day02;

public class IfTest 
{
    public static void main(String[] args) 
    {
        //需求1：根据用户定义的数值不同，打印对应的星期英文。
        /*
        int num=2;
        if(num==1)
        {
            System.out.println("ToDay Is Monday")
        }
        if(num==2)
        {
            System.out.println("ToDay Is Twoused");
        }
        System.out.println("Hello World!");
        */
        //需求2：根据用户指定月份，打印该月份所属的季节。
        int x=4;
        if(x==3||x==4||x==5)
        {
            System.out.println(x+"月春季");
        }
        else if(x==6||x==7||x==8)
        {
            System.out.println(x+"月夏季");
        }
            else if(x==9||x==10||x==11)
            {
                System.out.println(x+"月秋季");
            }
                else if(x==12||x==1||x==2)
                {
                    System.out.println(x+"月冬季");
                }
                    else
                    {
                        System.out.println(x+"月不存在");
                    }
    }
}
