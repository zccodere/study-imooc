package com.zccoder.javabase.day13;
/*
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
public class  StringTest2
{
    /*
    练习三：方式一：
    */
    public static int getSubCount(String str,String key)
    {
        int count=0;
        int index=0;
        while((index=str.indexOf(key))!=-1)
        {
            sop("str="+str);
            str=str.substring(index+key.length());
            count++;
        }
        return count;
    }

    /*
    练习三：方式二：
    */
    public static int getSubCount_2(String str,String key)
    {
        int count=0;
        int index=0;
        while((index=str.indexOf(key,index))!=-1)
        {
            sop("index="+index);
            index=index+key.length();
            count++;
        }
        return count;
    }

    public static void main(String[] args) 
    {
        String str="abkkcdkkefkkskk";
        sop("count="+getSubCount_2(str,"kk"));
    }

    public static void sop(String str)
    {
        System.out.println(str);
    }
}
