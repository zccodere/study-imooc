package com.zccoder.javabase.day08;
/*
多态：可以理解为事物存在的多种体现形态。

人：男人，女人。
动物：猫，狗。
猫 x=new 猫();
动物 x=new 猫();

多态的体现：
    父类的引用指向了自己的子类对象。
    父类的引用也可以接收自己的子类对象。
多态的前提：
    必须是类与类之间有关系。要么继承，要么实现。
    通常还有一个前提：存在覆盖。

多态的弊端：
    提高了扩展性，但是只能使用父类的引用访问父类中的成员。

多态的好处：
    多态的出现大大的提高了程序的扩展性。

多态的应用：

多态的出现代码中的特点（多态使用的注意事项）
*/

/*
动物，
猫，狗。
*/
abstract class Animal2
{
    public abstract void eat();
}
class Cat2 extends Animal2
{
    public void eat()
    {
        System.out.println("吃鱼");
    }
    public void catchMouse()
    {
        System.out.println("抓老鼠");
    }
}
class Dog2 extends Animal2
{
    public void eat()
    {
        System.out.println("吃骨头");
    }
    public void kanJia()
    {
        System.out.println("看家");
    }
}
class Pig2 extends Animal2
{
    public void eat()
    {
        System.out.println("饲料");
    }
    public void gongDi()
    {
        System.out.println("拱地");
    }
}

//----------------------------------------------------------

public class DuoTaiDemo2
{
    public static void main(String[] args) 
    {
        //Animal a=new Cat();//类型提升。向上转型。
        //a.eat();

        //如果想要调用猫的特有方法时，如何操作？
        //强制将父类的引用，转成子类类型。向下转型。
        //Cat c=(Cat)a;
        //c.catchMouse();

        /*千万不要出现这样的操作，就是将父类对象转成子类类型。
          我们能转换的是父类引用指向了自己的子类对象时，该引用可以被提升，也可以被强制转换。
          多态自始至终都是子类对象在做着变量。
        Animal a=new Animal();
        Cat c=(Cat)a;
        */
        function(new Dog2());
        function(new Cat2());
    }
    public static void function(Animal2 a)
    {
        a.eat();
        if(a instanceof Cat2)
        {
            Cat2 c=(Cat2)a;
            c.catchMouse();
        }
        else if(a instanceof Dog2)
        {
            Dog2 d=(Dog2)a;
            d.kanJia();
        }
    }
}
