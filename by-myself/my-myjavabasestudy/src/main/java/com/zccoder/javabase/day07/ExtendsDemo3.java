package com.zccoder.javabase.day07;
/*
2、子父类中的函数：
当子类出现和父类一模一样的函数时，当
子类对象调用该函数，会运行子类函数的内容。
如同父类的函数被覆盖一样。

这种情况是函数的另一个特性：重写（覆盖）。

单子类继承父类，沿袭了父类的功能，到子类中，
但是子类虽具备该功能，但是功能的内容却和父类不一致，
这时，没有必要定义新功能，而是使用覆盖特殊，保留父类的功能定义，并重写功能内容。

覆盖：
子类覆盖父类，必须保证子类权限大于等于父类权限，才可以覆盖，否则编译失败。静态只能覆盖静态。

记住大家：
重载：只看同名函数的参数列表。
重写：子父类方法要一模一样。
*/
class Fu3
{
    void show()
    {
        System.out.println("fu show");
    }
    void speak()
    {
        System.out.println("vb");
    }
}
class Zi3 extends Fu3
{
    void speak()
    {
        System.out.println("java");
    }
    void show()
    {
        System.out.println("zi show");
    }
}
public class ExtendsDemo3 
{
    public static void main(String[] args) 
    {
        Zi3 z=new Zi3();
        z.speak();
    }
}

class Tel
{
    void show()
    {
        System.out.println("number");
    }
}
class NewTel extends Tel
{
    void show()
    {
        //System.out.println("number");
        super.show();
        System.out.println("name");
        System.out.println("pic");
    }
}
