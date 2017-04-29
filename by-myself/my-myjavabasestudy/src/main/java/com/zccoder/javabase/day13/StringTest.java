package com.zccoder.javabase.day13;
/*
1，模拟一个trim方法，去除字符串两端的空格。
    思路：
    1，判断字符串第一个位置是否是空格，如果是继续向下判断，直到不是空格为止。
        结尾处判断空格也是如此。
    2，当开始和结尾都判断到不是空格时，就是要获取的字符串。

2，将一个字符串进行反转，将字符串中指定部分进行反转，"abcdefg"；abfedcg。
    思路：
    1，曾经学习过对数组的元素进程反转。
    2，将字符串变成数组，对该数组反转。
    3，将反转后的数组变成字符串。
    4，只要将或反转的部分的开始和结束位置作为参数传递即可。

3，获取一个字符串在另一个字符串中出现的次数。
    "abkkcdkkefkkskk"
    思路：
    1，定义个计数器。
    2，获取kk第一次出现的位置。
    3，从第一次出现位置后剩余的字符串中继续获取kk出现的位置。
        每获取一次就计数一次。
    4，当获取不到时，计数完成。

4，获取两个字符串中最大相同子串。第一个动作：将短的那个串进行长度一次递减的子串打印。
    "abcwerthelloyuiodef"
    "cvhellobnm"
    思路：
    1，将短的那个子串按照长度递减的方式获取到。
    2，将每获取到的子串去长串中判断是否包含。
        如果包含，已经找到！。
*/
public class StringTest
{
    public static void sop(String str)
    {
        System.out.println(str);
    }
    @SuppressWarnings("unused")
    public static void main(String[] args)
    {
        String s="   ab cd     ";

        /*练习二：
        sop("("+s+")");
        sop("("+reverseString(s,6,10)+")");
        sop("("+reverseString(s)+")");
        */
        /*练习一：
        sop("("+s+")");
        s=myTrim(s);
        sop("("+s+")");
        */
    }

    //练习二：将字符串反转。
    /*
    思路：
    1，将字符串变成数组。
    2，对数组反转。
    3，将数字变成字符串。
    */
    public static String reverseString(String s,int start,int end)
    {
        //字符串变数组。
        char[] chs=s.toCharArray();

        //反转数组。
        reverse(chs,start,end);

        //将数字变成字符串。
        return new String(chs);
    }
    public static String reverseString(String s)
    {
        return reverseString(s,0,s.length());
    }
    private static void reverse(char[] arr,int x,int y)
    {
        for(int start=x,end=y-1;start<end;start++,end--)
        {
            swap(arr,start,end);
        }
    }
    private static void swap(char[] arr,int x,int y)
    {
        char temp=arr[x];
        arr[x]=arr[y];
        arr[y]=temp;
    }

    //练习一：去除字符串两端空格。
    public static String myTrim(String str)
    {
        int start=0,end=str.length()-1;
        while(start<=end && str.charAt(start)==' ')
            start++;
        while(start<=end && str.charAt(end)==' ')
            end--;
        return str.substring(start,end+1);
    }
}
