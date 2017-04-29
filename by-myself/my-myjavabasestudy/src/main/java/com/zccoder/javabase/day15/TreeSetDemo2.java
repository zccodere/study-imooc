package com.zccoder.javabase.day15;
import java.util.*;
/*
当元素自身不具备比较性，或者具备的比较性不是所需要的。
这时需要让容器自身具备比较性。
定义了比较器，将比较器对象作为参数传递给TreeSet集合的构造函数。

当两种排序都存在时，以比较器为主。
定义一个类，实现Comparator接口，覆盖compare方法。
*/
@SuppressWarnings("rawtypes")
class StudentTree2 implements Comparable//该接口强制让学生具备比较性。
{
    private String name;
    private int age;

    StudentTree2(String name,int age)
    {
        this.name=name;
        this.age=age;
    }

    public int compareTo(Object obj)
    {
        if(!(obj instanceof StudentTree2))
            throw new RuntimeException("不是学生对象");
        StudentTree2 s=(StudentTree2)obj;
        //System.out.println(this.name+"...compareto..."+s.name);
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
class  TreeSetDemo2
{
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void main(String[] args) 
    {
        TreeSet ts = new TreeSet(new MyCompare());

        ts.add(new StudentTree2("lisi02",22));
        ts.add(new StudentTree2("lisi007",20));
        ts.add(new StudentTree2("lisi09",19));
        ts.add(new StudentTree2("lisi007",19));
        //ts.add(new StudentTree2("lisi01",40));

        Iterator it = ts.iterator();
        while(it.hasNext())
        {
            StudentTree2 stu=(StudentTree2)it.next();
            System.out.println(stu.getName()+"..."+stu.getAge());
        }
    }
}

@SuppressWarnings("rawtypes")
class MyCompare implements Comparator
{
    public int compare(Object o1,Object o2)
    {
        StudentTree2 s1=(StudentTree2)o1;
        StudentTree2 s2=(StudentTree2)o2;

        int num = s1.getName().compareTo(s2.getName());
        
        if(num==0)
            return new Integer(s1.getAge()).compareTo(s2.getAge());
        return num;
    }
}
