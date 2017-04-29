package com.zccoder.javabase.day15;
//泛型定义在接口上。
interface Inter<T>
{
    void show(T t);
}
/*
class InterImpl implements Inter<String>
{
    public void show(String t)
    {
        System.out.println("show:"+t);
    }
}
*/
class InterImpl<T> implements Inter<T>
{
    public void show(T t)
    {
        System.out.println("show:"+t);
    }
}
class GenericDemo5 
{
    public static void main(String[] args) 
    {
        InterImpl<Integer> i = new InterImpl<Integer>();
        i.show(4);
        //InterImpl i=new InterImpl();
        //i.show("haha");
    }
}
