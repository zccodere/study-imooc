package com.zccoder.javabase.day04;
public class ArrayTest7 
{
    public static void main(String[] args) 
    {
        //tobin(6);
        //tohex(60);
        toba(60);
    }
    /*十进制-->二进制*/
    public static void tobin(int num)//实现功能：十进制转二进制。
    {
        trans(num,1,1);
    }
    /*十进制-->八进制*/
    public static void toba(int num)//实现功能：十进制转八进制。
    {
        trans(num,7,3);
    }
    /*十进制-->十六进制*/
    public static void tohex(int num)//实现功能：十进制转十六进制。
    {
        trans(num,15,4);
    }
    public static void trans(int num,int base,int offset)//实现功能：十进制转N进制。
    {
        if (num==0)
        {
            System.out.println(0);
            return;
        }
        char[] chs={'0','1','2','3',
                    '4','5','6','7',
                    '8','9','A','B',
                    'C','D','E','F',};
        char[] arr=new char[32];
        int pos=arr.length;
        while(num!=0)
        {
            int temp=num&base;
            arr[--pos]=chs[temp];
            num=num>>>offset;
        }
        for (int x=pos; x<arr.length; x++)
        {
            System.out.print(arr[x]);
        }
    }
}
