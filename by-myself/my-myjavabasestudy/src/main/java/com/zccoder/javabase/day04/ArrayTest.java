package com.zccoder.javabase.day04;
/*
练习：
给定一个数组{5,1,6,4,1,8,9}。
1，获取数组中的最大值，以及最小值。
*/

/*
ZC思路：
定义一个变量用来存放最大值或最小值。
用数组中的每一个元素去和变量比较。
当元素大于或小于变量时，把元素的值赋值给变量。
可以定义两个功能来实现。
TC思路：
1，获取最值需要进行比较。每一次比较都会有一个较大的值。因为该值不确定。通过一个变量进行临储。
2，让数组中的每一个元素都和这个变量中的值进行比较。如果大于了变量中的值，就用该变量记录较大值。
3，当所有的元素都比较完成，那么该变量中存储的就是数组中的最大值了。
TC步骤：
1，定义变量。初始化为数组中的任意一个元素即可。
2，通过循环语句对数组进行遍历。
3，在遍历过程中定义判断条件，如果遍历到的元素比变量中的元素大，就赋值给该变量。

需要定义一个功能来完成。以便提高复用性。
1，明确结果：数组中的最大元素int。
2，未知内容：一个数组。int[]。
*/
public class  ArrayTest
{
    public static void main(String[] args) 
    {
        int[] arr=new int[]{5,1,6,4,1,8,9};
        System.out.println("Max="+ArrayMax(arr));
        System.out.println("Min="+ArrayMin(arr));
    }
    public static int ArrayMax(int[] arr)//实现功能：找出数组中元素的最大值。
    {
        int max=arr[0];
        for(int x=1;x<arr.length;x++)
        {
            if(arr[x]>max)
            {
                max=arr[x];
            }
            else
            {
                continue;
            }
        }
        return max;
    }
    //获取double类型数组的最大值。因为功能一致，所以定义相同函数名称，一重载形式存在。
    /*
    public static double ArrayMax(double[] arr)
    {

    }
    */
    public static int ArrayMin(int[] arr)//实现功能：找出数组中元素的最小值。
    {
        int min=arr[0];
        for(int x=1;x<arr.length;x++)
        {
            if(arr[x]<min)
            {
                min=arr[x];
            }
            else
            {
                continue;
            }
        }
        return min;
    }
}
