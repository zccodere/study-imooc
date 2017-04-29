package com.zccoder.javabase.day17;
/*
JDK1.5版本出现的新特性。

方法的可变参数。
在使用时注意：可变参数一定要定义在参数列表最后面。
*/

class  ParamMethodDemo
{
    public static void main(String[] args) 
    {
        //show(3,4);
        /*
        虽然少定义了多个方法。
        但是每次都要定义一个数组。作为实际参数。
        int [] arr={3,4}
        show(arr);
        int[] arr1={2,3,4,5};
        show(arr1);
        */

        /*
        可变参数。
        其实就是上一种数组参数的简写形式。
        不用每一次都手动的建立数组对象。
        只要将要操作的元素作为参数传递即可。
        隐式将这些参数封装成了数组。
        */
        show("haha",2,3,4,5,6);
        //show(2,3,4,5,6,4,2,35,9);
        //show();
    }
    public static void show(String str,int... arr)
    {
        System.out.println(arr.length);
    }
    /*public static void show(int[] arr)
    {
    }*/
    /*
    public static void show(int a,int b)
    {
        System.out.println(a+","+b);
    }
    public static void show(int a,int b,int c)
    {
    }
    */
}
