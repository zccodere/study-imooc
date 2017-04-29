package com.zccoder.javabase.day16;
/*
每一个学生都有对应的归属地。
学生StudentMap，地址String。
学生属性：姓名，年龄。
注意：姓名和年龄相同的视为同一个学生。
保证学生的唯一性。

1，描述学生。
2，定义Map容器，将学生作为键，地址作为值，存入。
3，获取map集合中的元素。
*/
import java.util.*;
class StudentMap implements Comparable<StudentMap>
{
    private String name;
    private int age;
    StudentMap(String name,int age)
    {
        this.name=name;
        this.age=age;
    }
    public int compareTo(StudentMap s)
    {
        int num=new Integer(this.age).compareTo(new Integer(s.age));
        if(num==0)
            return this.name.compareTo(s.name);
        return num;
    }
    public int hashCode()
    {
        return name.hashCode()+age*34;
    }
    public boolean equals(Object obj)
    {
        if(!(obj instanceof StudentMap))
            throw new ClassCastException("类型不匹配");
        StudentMap s=(StudentMap)obj;
        return this.name.equals(s.name) && this.age==s.age;
    }
    public String getName()
    {
        return name;
    }
    public int getAge()
    {
        return age;
    }
    public String toString()
    {
        return name+":"+age;
    }
}
class MapTest 
{
    public static void main(String[] args) 
    {
        HashMap<StudentMap,String> hm=new HashMap<StudentMap,String>();
        hm.put(new StudentMap("lisi1",21),"beijing");
        hm.put(new StudentMap("lisi1",21),"tianjin");
        hm.put(new StudentMap("lisi2",22),"shanghai");
        hm.put(new StudentMap("lisi3",23),"nanjing");
        hm.put(new StudentMap("lisi4",24),"wuhan");

        //第一种取出方式 keySet
        Set<StudentMap> keySet = hm.keySet();
        Iterator<StudentMap> it=keySet.iterator();
        while(it.hasNext())
        {
            StudentMap stu=it.next();
            String addr = hm.get(stu);
            System.out.println(stu+"..."+addr);
        }


        //第二种取出方式 entrySet
        Set<Map.Entry<StudentMap,String>> entrySet = hm.entrySet();
        Iterator<Map.Entry<StudentMap,String>> iter=entrySet.iterator();
        while(iter.hasNext())
        {
            Map.Entry<StudentMap,String> me=iter.next();
            StudentMap stu = me.getKey();
            String addr = me.getValue();
            System.out.println(stu+"......"+addr);
        }
    }
}
