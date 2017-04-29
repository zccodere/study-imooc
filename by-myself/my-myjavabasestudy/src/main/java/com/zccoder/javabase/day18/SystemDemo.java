package com.zccoder.javabase.day18;
/*
System:类中的方法和属性都是静态的。
out:标准输出，默认是控制台。
int:标准输入，默认是键盘。

描述系统一些信息。

获取系统属性信息：Properties getProperties();
*/
import java.util.*;
class SystemDemo 
{
    @SuppressWarnings("unused")
    public static void main(String[] args) 
    {
        Properties prop=System.getProperties();
        //因为Properties是Hashtable的子类，也就是Map集合的一个子类对象。
        //那么可以通过map的方法取出该集合中的元素。
        //该集合中存储都是字符串。没有泛型定义。

        //如何在系统中自定义一些特有信息呢？
        System.setProperty("mykey","myvalue");

        ///*
        //获取制定属性信息。
        String value=System.getProperty("os.name");
        System.out.println("value:"+value);
        //*/

        //可不可以在jvm启动时，动态加载一些属性信息呢？
        String v=System.getProperty("haha");
        System.out.println("v="+v);
        
        /*
        获取所有属性信息。
        for(Object obj:prop.keySet())
        {
            String value=(String)prop.get(obj);
            System.out.println(obj+"::"+value);
        }
        */
        
    }
}
