package com.zccoder.javabase.day15;
import java.util.*;
/*
Set：无序，不可以重复元素。
    |--HashSet：数据结构是哈希表。线程是非同步的。
                保证元素唯一性的原理：判断元素的hashCode值是否相同。
                如果相同，还会继续判断元素的equals方法，是否为true。
    |--TreeSet：可以对Set集合中的元素进行排序。
                底层数据结构是二叉树。
                保证元素唯一性的依据：
                compareTo方法和return 0。

                TreeSet排序的第一种方式：让元素自身具备比较性。
                元素需要实现comparable接口，覆盖comparaeTo方法。
                这种方式也称为元素的自然顺序，或者默认顺序。

                TreeSet排序的第二种方式：当元素自身不具备比较性时，
                或者具备的比较性不是所需要的。这时就需要让集合自身具备比较性。


需求：
往TreeSet集合中存储自定义对象学生。
想按照学生的年龄进行排序。

记住，排序时，当主要条件相同时，一定要判断一下次要条件。
*/
class TreeSetDemo 
{
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void main(String[] args) 
    {
        TreeSet ts = new TreeSet();

        ts.add(new StudentTree1("lisi02",22));
        ts.add(new StudentTree1("lisi007",20));
        ts.add(new StudentTree1("lisi09",19));
        ts.add(new StudentTree1("lisi08",19));
        //ts.add(new Student("lisi01",40));

        Iterator it = ts.iterator();
        while(it.hasNext())
        {
            StudentTree1 stu=(StudentTree1)it.next();
            System.out.println(stu.getName()+"..."+stu.getAge());
        }
    }
}

@SuppressWarnings("rawtypes")
class StudentTree1 implements Comparable//该接口强制让学生具备比较性。
{
    private String name;
    private int age;

    StudentTree1(String name,int age)
    {
        this.name=name;
        this.age=age;
    }

    public int compareTo(Object obj)
    {
        if(!(obj instanceof StudentTree1))
            throw new RuntimeException("不是学生对象");
        StudentTree1 s=(StudentTree1)obj;
        System.out.println(this.name+"...compareto..."+s.name);
        if(this.age>s.age)
            return 1;
        if(this.age==s.age)
        {
            return this.name.compareTo(s.name);
        }
        return -1;
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
