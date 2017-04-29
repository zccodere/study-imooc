package com.zccoder.javabase.day09;
/*
内部类的访问规则：
1，内部类可以直接访问外部类中的成员，包括私有。
    之所以可以直接访问外部类中的成员，是因为内部类中持有了一个外部类的引用，格式：外部类名.this。
2，外部类要访问内部类，必须要建立内部类对象。
*/
class Outer1
{
    private int x=3;
    class Inner//内部类
    {
        int x=4;
        @SuppressWarnings("unused")
        void function()
        {
            int x=6;
            System.out.println("inner："+Outer1.this.x);
        }
    }
    void method()
    {
        Inner in=new Inner();
        in.function();
    }
}
public class  InnerClassDemo
{
    public static void main(String[] args) 
    {
        Outer1 out=new Outer1();
        out.method();
        
        //直接访问内部类中的成员。
        //Outer.Inner in=new Outer().new Inner();
        //in.function();
    }
}
