package com.zccoder.javabase.day03;
/*
什么时候用重载？
当定义的功能相同，但参与运算的未知内容不同。
那么，这时就定义一个函数名称以表示其功能，方便阅读，
而通过参数列表的不同来区分多个同名函数。
*/
public class  FunctionOverload
{
    public static void main(String[] args) 
    {
//        add(4,5);
//        add(4,5,6);
//        add(1.2,1.3);
        print99();
    }

    //打印99乘法表
    public static void print99(int num)
    {
        for(int x=1;x<=num;x++)
        {
            for(int y=1;y<=x;y++)
            {
                System.out.print(y+"*"+x+"="+y*x+"\t");
            }
            System.out.println();
        }
    }
    public static void print99()
    {
        print99(9);
    }

    //定义一个加法运算，获取两个整数的和。
    public static int add(int x,int y)
    {
        return x+y;
    }

    //定义一个加法运算，获取三个整数的和。
    public static int add(int x,int y,int z)
    {
        return add(x,y)+z;
    }

    //定义一个加法运算，获取两个小数的和。
    public static double add(double x,double y)
    {
        return x+y;
    }
}

/*
void show(int a,char b,double c){}

a.
void show(int x,char y,double z){}//没有，因为和原函数一样。

b.
int show(int a,doublec,char b){}//重载，因为参数类型不同。注意：重载和返回值类型没关系。

c.
void show(int a,double c,char b){}//重载，因为参数类型不同。注意：重载和返回值类型没关系。

d.
boolean show(double c){}//重载，因为参数个数不同。

e.
void show(double c){}//重载，因为参数个数不同。

f.
double show(int x,char y,double z){}//没有，这个函数不可以和给定函数同时存在一个类中。

*/
