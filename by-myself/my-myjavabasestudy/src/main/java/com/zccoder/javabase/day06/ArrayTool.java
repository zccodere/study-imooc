package com.zccoder.javabase.day06;
/*
静态的应用。

每一个应用程序中都有共性的功能，可以将这些功能进行抽取，独立封装。以便复用。

虽然可以通过建立ArrayTool的对象使用这些工具方法，对数组进行操作。
1，对象是用于封装数据的，可以ArrayTool对象并未封装特特有数据。
2，操作数组的每一个方法都没有用到ArrayTool对象中的特有数据。

这时就考虑，让程序更严谨，是不需要对象的。
可以将ArrayTool中的方法都定义成static的，直接通过类名调用即可。

将方法都静态后，可以方便于使用，但是该类还是可以被其他程序建立对象的。
为了更为严谨，强制让该类不能建立对象。
可以通过将构成函数私有化完成。

接下来，将ArrayTool.class文件发送给其他人，其他人只要将该文件设置到classpath路径下，就可以使用该工具类。
但是，很遗憾，该类中到底定义了多少个方法，对方不清楚。因为该类并没有使用说明书。
开始制作程序的说明书。java的说明书通过文档注释来完成。
*/


/**
这是一个可以对数组进行操作的工具类，该类中提供了，获取最值，排序等功能。
@author 张程
@version v1.0
*/
public class ArrayTool
{
    /**
    空参数构造函数。
    */
    private ArrayTool()
    {
    }
    /**
    获取一个整形数组中的最大值。
    @param arr 接收一个int类型的数组。
    @return 会返回一个该数组中最大值。
    */
    public static int getMax(int[] arr)
    {
        int max=0;
        for(int x=1;x<arr.length;x++)
        {
            if(arr[x]>arr[max])
                max=x;
        }
        return arr[max];
    }
    /**
    获取一个整形数组中的最小值。
    @param arr 接收一个int类型的数组。
    @return 会返回一个该数组中最小值。
    */
    public static int getMin(int[] arr)
    {
        int min=0;
        for(int x=1;x<arr.length;x++)
        {
            if(arr[x]<arr[min])
                min=x;
        }
        return arr[min];
    }
    /**
    给int数组进行选择排序。
    @param arr 接收一个int类型的数组。
    */
    public static void selectSort(int[] arr)
    {
        for(int x=0;x<arr.length-1;x++)
        {
            for(int y=x+1;y<arr.length;y++)
            {
                if(arr[x]>arr[y])
                {
                    swap(arr,x,y);
                }
            }
        }
    }
    /**
    给int数组进行冒泡排序。
    @param arr 接收一个int类型的数组。
    */
    public static void bubbleSort(int[] arr)
    {
        for(int x=0;x<arr.length-1;x++)
        {
            for(int y=0;y<arr.length-x-1;y++)
            {
                if(arr[y]>arr[y+1])
                {
                    swap(arr,y,y+1);
                }
            }
        }
    }
    /**
    给数组中元素进行位置的置换。
    @param arr 接收一个int类型的数组。
    @param a 要置换的位置。
    @param b 要置换的位置。
    */
    private static void swap(int[] arr,int a,int b)
    {
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
    /**
    用于打印数组中的元素。d打印形式是：[elemet1,elemet2,...]
    */
    public static void printArray(int[] arr)
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
}

/*
一个类中默认会有一个空参数的构造函数。
这个默认的构造函数的权限和所属类一致。
如果类被public修饰，那么默认的构造函数也带public修饰符。
如果类没有被public修饰，那么默认的构造函数，也没有public修饰。

默认构造函数的权限是随着类的变化而变化的。
*/

































class Demo
{
    public static void main(String[] args)
    {
        int[] arr={3,4,5,8};
        int max=getMax(arr);
        System.out.println("max="+max);
    }
    public static int getMax(int[] arr)
    {
        int max=0;
        for(int x=1;x<arr.length;x++)
        {
            if(arr[x]>arr[max])
                max=x;
        }
        return arr[max];
    }
}
class Test
{
    public static int getMax(int[] arr)
    {
        int max=0;
        for(int x=1;x<arr.length;x++)
        {
            if(arr[x]>arr[max])
                max=x;
        }
        return arr[max];
    }
}
