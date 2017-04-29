package com.zccoder.javabase.day04;
/*
对给定数组进行排序。
{5,1,6,4,2,8,9}
*/
public class  ArrayTest2
{
    /*
    选择排序。
    内循环结束一次，最值出现头角标位置。
    */
    public static void SelectSort(int[] arr)//实现功能：数组选择排序。
    {
        for (int x=0; x<arr.length-1; x++)
        {
            for (int y=x+1; y<arr.length; y++)
            {
                if (arr[x]>arr[y])
                {
                    int temp=arr[x];
                    arr[x]=arr[y];
                    arr[y]=temp;
                }
            }
            
        }
    }
    public static void printArray(int[] arr)//实现功能：打印数组。
    {
        System.out.print("[");
        for(int x=0;x<arr.length;x++)
        {
            if(x!=arr.length-1)
            {
                System.out.print(arr[x]+",");
            }
            else
            {
                System.out.println(arr[x]+"]");
            }
        }        
    }
    /*
    冒泡排序。
    第一圈：最值出现在了最后位。
    */
    public static void BubbleSort(int[] arr)//实现功能：数组冒泡排序。
    {
        for (int x=0; x<arr.length-1; x++)
        {
            for (int y=0; y<arr.length-x-1; y++)//-x：让每一次比较的元素较少，-1：避免角标越界。
            {
                if(arr[y]>arr[y+1])
                {
                    int temp=arr[y];
                    arr[y]=arr[y+1];
                    arr[y+1]=temp;
                }
            }
        }
    }
    /*
    发现无论什么排序，都需要对满足条件的元素进行位置置换。
    所有可以把这部分相同的代码提取出来，单独封装成一个函数。
    */
    public static void swap(int[] arr,int a,int b)//实现功能：数据元素换位置。
    {
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
    public static void main(String[] args) 
    {
        int[] arr={5,1,6,4,2,8,9};
        //排序前。
        printArray(arr);
        //排序。
        BubbleSort(arr);
        //排序后。
        printArray(arr);
    }
    //java中排序工具
    /*
    import.java.util.*;
    Array.sort(arr);java中已经定义好的一种排序方式。开发中，对数组排序，要使用该句代码。
    */
}
