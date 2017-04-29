package com.zccoder.javabase.day16;
/*
需求：对学生对象的年龄进行升序排序。

因为数据是以键值对形式存在的。
所以要使用可以排序的Map集合。TreeMap。
*/

import java.util.*;
class StuNameComparator implements Comparator<StudentMap>
{
    public int compare(StudentMap s1,StudentMap s2)
    {
        int num = s1.getName().compareTo(s2.getName());
        if(num==0)
            return new Integer(s1.getAge()).compareTo(new Integer(s2.getAge()));
        return num;
    }
}
class  MapTest2
{
    public static void main(String[] args) 
    {
        TreeMap<StudentMap,String> tm=new TreeMap<StudentMap,String>(new StuNameComparator());

        tm.put(new StudentMap("lisi1",21),"beijing");
        //tm.put(new StudentMap("lisi1",21),"tianjin");
        tm.put(new StudentMap("lisi2",22),"shanghai");
        tm.put(new StudentMap("blisi3",23),"nanjing");
        tm.put(new StudentMap("alisi4",24),"wuhan");

        Set<Map.Entry<StudentMap,String>> entrySet = tm.entrySet();
        Iterator<Map.Entry<StudentMap,String>> it=entrySet.iterator();
        while(it.hasNext())
        {
            Map.Entry<StudentMap,String> me = it.next();
            StudentMap stu = me.getKey();
            String addr = me.getValue();
            System.out.println(stu+"..."+addr);
        }
    }
}
