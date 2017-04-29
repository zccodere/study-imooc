package com.zccoder.javabase.day04;
public class ArrayDemo2 
{
    @SuppressWarnings("null")
    public static void main(String[] args) 
    {
        /*
        格式一：
        int[] arr = new int[2];
        int arr[] = new int[2];
        */
        /*
        格式二：
        int[] arr = new int[]{3,1,6,5,4};//静态初始化
        int[] arr={3,1,6,5,4};
        
        int[] arr={3,1,6,5,4};
        System.out.println(arr[2]);
        */

        int[] arr = new int[3];
        arr = null;
        System.out.println(arr[3]);
        //ArrayIndexOutOfBoundsException: 3：操作数组时，访问到数组中不存在的角标。

        //NullPointerException：空指针异常：当应用没有任何指向值为null的情况，该引用还在用于操作实体。
    }
}
