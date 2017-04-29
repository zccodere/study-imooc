package com.zccoder.javabase.day14;
/*
Collection
    |--List:元素是有序的，元素可以重复。因为该集合体系有索引。
        |--ArrayList:底层的数据结构使用的是数组结构。特点：查询速度很快。但是增删稍慢。线程不同步。
        |--LinkedList:底层使用的是链表数据结构。特点：增删速度很快，查询速度稍慢。
        |--Vector:底层是数据数据结构。线程同步。被ArrayList替代了。
    |--Set:元素是无序的，元素不可以重复。

List:
    特有方法。凡是可以操作角标的方法都是该体系特有的方法。
增
    add(index,element);
    addAll(index,Collection);
删
    remove(index);
改
    set(index,element);
查
    get(index);
    subList(from,to);
    listIterator();

List集合特有的迭代器。ListIterator是Iterator的子接口。
在迭代时，不可以通过集合对象的方法操作集合中的元素。
因为会发生ConcurrentModificationException异常。

所有，在迭代器时，只能用迭代器的方法操作元素，可以Iterator方法时优先的，
只能对元素进行判断，取出，删除的操作，
如果想要其他的操作如添加，修改等，就需要使用其子接口，ListIterator。

该接口只能通过List集合的ListIterator方法获取。
*/
import java.util.*;
@SuppressWarnings({ "unchecked", "rawtypes" })
class ListDemo 
{
    public static void sop(Object obj)
    {
        System.out.println(obj);
    }

    public static void method()
    {
        ArrayList al=new ArrayList();

        //添加元素。
        al.add("java01");
        al.add("java02");
        al.add("java03");
        sop("原集合是:"+al);

        //在指定位置添加元素。
        al.add(1,"java09");

        //删除指定位置的元素。
        //al.remove(2);

        //修改元素。
        //al.set(2,"java007");

        //通过角标获取元素。
        sop("get(1):"+al.get(1));

        sop(al);

        //获取所有元素。
        for(int x=0;x<al.size();x++)
        {
            sop("al("+x+")="+al.get(x));
        }

        Iterator it=al.iterator();
        while(it.hasNext())
        {
            sop("next:"+it.next());
        }


        //通过indexOf获取对象的位置。
        sop("index="+al.indexOf("java02"));

        List sub=al.subList(1,3);
        sop("sub="+sub);
    }
    public static void main(String[] args) 
    {
        //演示列表迭代器。
        ArrayList al=new ArrayList();

        //添加元素。
        al.add("java01");
        al.add("java02");
        al.add("java03");
        
        sop(al);

        ListIterator li=al.listIterator();
        while(li.hasNext())
        {
            Object obj=li.next();
            if(obj.equals("java02"))
                //li.add("java009");
            li.set("java006");
        }
        while(li.hasPrevious())
        {
            sop("Previous:"+li.previous());
        }
        //sop("hasNext():"+li.hasNext());
        //sop("hasPrevious():"+li.hasPrevious());

        sop(al);
        /*
        //在迭代过程中，准备添加或者删除元素。
        Iterator it=al.iterator();
        while(it.hasNext())
        {
            Object obj=it.next();
            if(obj.equals("java02"))
                //al.add("java008");
                it.remove();
            sop("obj="+obj);
        }
        sop(al);
        */
    }
}
