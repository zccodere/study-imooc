package com.zccoder.javabase.day15;
import java.util.*;
class  GenericDemo7
{
    public static void main(String[] args) 
    {
        /*
        TreeSet<Student> ts = new TreeSet<Student>(new StuComp());

        ts.add(new Student("abc03"));
        ts.add(new Student("abc02"));
        ts.add(new Student("abc06"));
        ts.add(new Student("abc01"));
        Iterator<Student> it = ts.iterator();
        while(it.hasNext())
        {
            System.out.println(it.next().getName());
        }
        */
        
        TreeSet<Worker7> ts1 = new TreeSet<Worker7>(new Comp());

        ts1.add(new Worker7("wabc--03"));
        ts1.add(new Worker7("wabc--02"));
        ts1.add(new Worker7("wabc--06"));
        ts1.add(new Worker7("wabc--01"));
        Iterator<Worker7> it1 = ts1.iterator();
        while(it1.hasNext())
        {
            System.out.println(it1.next().getName());
        }
    }
}
/*
class StuComp implements Comparator<Student>
{
    public int compare(Student s1,Student s2)
    {
        return s1.getName().compareTo(s2.getName());
    }
}
class WorkerComp implements Comparator<Worker>
{
    public int compare(Worker s1,Worker s2)
    {
        return s1.getName().compareTo(s2.getName());
    }
}
*/

class Comp implements Comparator<Person7>
{
    public int compare(Person7 p1,Person7 p2)
    {
        return p2.getName().compareTo(p1.getName());
    }
}
class Person7
{
    private String name;
    Person7(String name)
    {
        this.name=name;
    }
    public String getName()
    {
        return name;
    }
}

class Student7 extends Person7
{
    Student7(String name)
    {
        super(name);
    }
}

class Worker7 extends Person7
{
    Worker7(String name)
    {
        super(name);
    }
}
