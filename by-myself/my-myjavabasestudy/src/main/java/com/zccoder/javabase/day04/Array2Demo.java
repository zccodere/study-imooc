package com.zccoder.javabase.day04;

public class Array2Demo 
{
    public static void main(String[] args) 
    {
        //int[] arr=new int[3];//一维数组。
        //int[][] arr=new int[3][4];
        //定义了名称为arr的二维数组，二维数组中有3个一维数组。
        //每一个一维数组中有4个元素。
        /*
        int[][] arr=new int[3][];
        arr[0]=new int[3];
        arr[1]=new int[1];
        arr[2]=new int[2];
        System.out.println(arr.length);//打印是二维数组的长度3。
        System.out.println(arr[0].length);//打印是二维数组中第一个一维数组长度。
        */
        int[][] arr={{3,5,1,7},{2,3,5,8},{6,1,8,2}};
        int sum=0;
        for (int x=0; x<arr.length; x++)
        {
            for (int y=0; y<arr[x].length; y++)
            {
                sum=sum+arr[x][y];
            }
        }
        System.out.println("sum="+sum);
    }
}
/*
小练习：
int[] x;int x[];
int[][] y;int y[][];int[] y[];

int[] x,y[];//x一维，y二维。
int[] x;
int[] y[];

a.
x[0]=y;//error

b.
y[0]=x;//yes

c.
y[0][0]=x;//error

d.
x[0][0]=y;//error

e.
y[0][0]=x[0];//yes

f.
x=y;//error
*/
