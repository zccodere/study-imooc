
package com.zccoder.javabase.day06;
class Person
{
    private String name;
    private int age;
    private static String country="cn";
    Person(String name,int age)
    {
        this.name=name;
        this.age=age;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public void speak()
    {
        System.out.println("name="+this.name+"...age="+this.age);
    }
    public static void showCountry()
    {
        System.out.println("country="+country);
    }
    public static void method()
    {
        System.out.println("method run");
    }
}
public class PersonDemo
{
    public static void main(String[] args) 
    {
        System.out.println("Hello World!");
    }
}
