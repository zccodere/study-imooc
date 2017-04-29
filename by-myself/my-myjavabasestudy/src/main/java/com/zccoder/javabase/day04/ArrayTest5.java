package com.zccoder.javabase.day04;
public class ArrayTest5 
{
    public static void main(String[] args) 
    {
        //tobin(6);
        tohex(60);
    }

    /*
    十进制转化成二进制。
    */
    public static void tobin(int num)//实现功能：把十进制转化成二进制打印。
    {
        StringBuffer sb=new StringBuffer();
        while(num>0)
        {
            //System.out.print(num%2);
            sb.append(num%2);
            num=num/2;
        }
        System.out.println(sb.reverse());
    }

    /*
    十进制转化成十六进制。
    */
    public static void tohex(int num)//实现功能：把十进制转化成十六进制打印。
    {
        StringBuffer sb=new StringBuffer();
        for(int x=0;x<8;x++)
        {
            int temp=num&15;
            if (temp>9)
            {
                //System.out.println((char)(temp-10+'A'));
                sb.append((char)(temp-10+'A'));
            }
            else
            {
                //System.out.println(temp);
                sb.append(temp);
            }
            num=num>>>4;
        }
        System.out.println(sb.reverse());
    }
}
