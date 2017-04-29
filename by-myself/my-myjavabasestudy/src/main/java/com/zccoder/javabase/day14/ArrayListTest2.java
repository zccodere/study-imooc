package com.zccoder.javabase.day14;
/*
将自定义对象作为元素存到ArrayList集合中，并去除重复元素。

比如：存人对象。同姓名同年龄，视为同一个人。为重复元素。

思路：
1，对人描述，将数据封装进人对象。
2，定义容器，将人存入。
3，取出。


List集合判断元素是否相同，依据是元素的equals方法。
*/
import java.util.*;
class Person2
{
    private String name;
    private int age;
    Person2(String name,int age)
    {
        this.name=name;
        this.age=age;
    }
    public boolean equals(Object obj)
    {
        
        if(!(obj instanceof Person2))
            return false;
        Person2 p=(Person2)obj;
        System.out.println(this.name+"...."+p.name);
        return this.name.equals(p.name)&&this.age==p.age;
    }
    public String getName()
    {
        return name;
    }
    public int getAge()
    {
        return age;
    }
}
class ArrayListTest2 
{
    public static void sop(Object obj)
    {
        System.out.println(obj);
    }
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void main(String[] args) 
    {
        ArrayList al=new ArrayList();
        al.add(new Person2("lisi01",30));//al.add(Object obj);//Object obj=new Person("lisi01",30)
        al.add(new Person2("lisi02",32));
        al.add(new Person2("lisi02",32));
        al.add(new Person2("lisi03",33));
        al.add(new Person2("lisi04",35));
        al.add(new Person2("lisi04",35));
        
        //al = singleElement(al);

        sop("remove 03:"+al.remove(new Person2("lisi03",33)));
        Iterator it=al.iterator();
        while(it.hasNext())
        {
            Person2 p=(Person2)it.next();
            sop(p.getName()+"::"+p.getAge());
        }
    }
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static ArrayList singleElement(ArrayList al)
    {
        //定义一个临时容器。
        ArrayList newAl=new ArrayList();
        Iterator it=al.iterator();
        while(it.hasNext())
        {
            Object obj=it.next();
            if(!newAl.contains(obj))
                newAl.add(obj);
        }
        return newAl;
    }
}
