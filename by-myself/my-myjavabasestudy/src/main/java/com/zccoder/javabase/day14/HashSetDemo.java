package com.zccoder.javabase.day14;
import java.util.*;
/*
|--Set:元素是无序(存入和取出的顺序不一定一致)，元素不可以重复。
    |--HaseSet:底层数据结构是哈希表。
            HaseSet是如何保证元素唯一性的呢？
            是通过元素的两个方法，hashCode和equals来完成。
            如果元素的hashCode值相同，才会判断equals是否为true。
            如果元素的hashCode值不同，不会调用equals。

            注意：对于判断元素是否存在，以及删除操作，依赖的方法时元素的hashcode和equals方法。
    |--TreeSet:
Set集合的功能和Collecion是一致的。
*/

class Demo
{
}
class  HashSetDemo
{
    public static void sop(Object obj)
    {
        System.out.println(obj);
    }
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void main(String[] args) 
    {
        HashSet hs=new HashSet();

        sop(hs.add("java01"));
        sop(hs.add("java01"));
        hs.add("java02");
        hs.add("java03");
        hs.add("java03");
        hs.add("java04");

        Iterator it = hs.iterator();

        while(it.hasNext())
        {
            sop(it.next());
        }
    }
}
