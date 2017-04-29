package com.zccoder.javabase.day03;
public class FunctionDemo2 
{
    public static void main(String[] args) 
    {
        int sum=getsum(4,6);
        System.out.println("sum="+sum);
    }

    /*
    这个功能定义思想有问题，为什么呢？因为只为完成加法运算，至于是否要对和进行打印操作。
    那是调用者的事，不要在该功能中完成。
    public static void get(int a,int b)
    {
        System.out.println(a+b);
        return;
    }
    */

    /*
    如何定义一个函数呢？
    a：既然函数是一个独立的功能，那么该功能的运算结果是什么先明确。
        因为这是在明确函数的返回值类型。
    b：再明确在定义该功能的过程中是否需要未知的内容参与运算。
        因为是在明确函数的参数列表（参数的类型和参数的个数）。
    */
    //需求：定义一个功能。完成3+4的运算。并将结果返回给调用者。
    /*
    思路：
    1:明确功能的结果：是一个整数的和。
    2：在实现该功能的过程中是否有未知的内容参与运算，没有。
    其实这两个功能就是在明确函数的定义。
    1，是在明确函数的返回值类型。
    2，是在明确函数的参与列表（参数的类型和参与的个数）。
    

    public static int getsum()
    {
        return 3+4;
    }
    */
    /*
    以上这个函数的功能，结果是固定的，毫无扩展性而言。
    为了方便用户需求。由用户来指定加数和被加数。这样，功能才有意义。
    思路：
    1，功能结果是一个和，返回值类型是int。
    2，有未知内容参与运算。有两个。这个两个未知内容的类型都是int。
    */
    public static int getsum(int x,int y)
    {
        return x+y;
    }

    /*
    需求：判断两个数是否相同。
    思路：
    1，明确功能是结果：结果是：boolean。
    2，功能是否有未知内容参与运算。有，两个整数。
    */
    public static boolean compare(int a,int b)
    {
        /*
        if(a==b)
            return true;
        else
            return false;
        */
        //return(a==b)?true:false;
        return a==b;
    }
    /*
    需求：定义功能，对两个数进行比较。获取较大的数。
    */
    public static int getmax(int a,int b)
    {
        /*
        if(a>b)
            return a;
        else
            return b;
        */
        return (a>b)?a:b;
    }
}
