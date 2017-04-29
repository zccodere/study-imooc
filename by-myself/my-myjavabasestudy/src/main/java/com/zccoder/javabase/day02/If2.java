package com.zccoder.javabase.day02;

public class  If2
{
    public static void main(String[] args) 
    {
        int x=4;
        if(x==3||x==4||x==5)
        {
            System.out.println(x+"1");
        }
        else if(x==6||x==7||x==8)
        {
            System.out.println(x+"2");
        }
            else if(x==9||x==10||x==11)
            {
                System.out.println(x+"3");
            }
                else if(x==12||x==1||x==2)
                {
                    System.out.println(x+"4");
                }
                    else
                    {
                        System.out.println(x+"5");
                    }
    }
}
