package com.zccoder.javabase.day10;
public class  PackageDemo
{
    @SuppressWarnings("unused")
    public static void main(String[] args) 
    {
        DemoC c=new DemoC();
        
        
        //packa.DemoA d=new packa.DemoA();
        //d.show();

        //packb.DemoB d=new packb.DemoB();
        //d.method();
    }
}

/*
---------------------------------------------------
PackageDemo.java:6: 错误: 找不到符号
                DemoA d=new DemoA();
                ^
  符号:   类 DemoA
  位置: 类 PackageDemo
PackageDemo.java:6: 错误: 找不到符号
                DemoA d=new DemoA();
                            ^
  符号:   类 DemoA
  位置: 类 PackageDemo
2 个错误

错误原因：类名写错。

因为类名的全名是：包名.类名

---------------------------------------------------
PackageDemo.java:6: 错误: 找不到符号
                DemoA d=new DemoA();
                ^
  符号:   类 DemoA
  位置: 类 PackageDemo
PackageDemo.java:6: 错误: 找不到符号
                DemoA d=new DemoA();
                            ^
  符号:   类 DemoA
  位置: 类 PackageDemo
2 个错误

错误原因：packa包不在当前目录下
需要设置classpath，告诉jvm去哪里找指定的packa包。

---------------------------------------------------
PackageDemo.java:6: 错误: 找不到符号
                DemoA d=new DemoA();
                ^
  符号:   类 DemoA
  位置: 类 PackageDemo
PackageDemo.java:6: 错误: 找不到符号
                DemoA d=new DemoA();
                            ^
  符号:   类 DemoA
  位置: 类 PackageDemo
2 个错误

错误原因：有了包，范围变大，一个包中的类要被访问，必须要有足够大的权限。
所以被访问的类要被public修饰。
---------------------------------------------------
PackageDemo.java:7: 错误: show()在DemoA中不是公共的; 无法从外部程序包中对其进行
访问
                d.show();
                 ^
1 个错误

错误原因：类公有以后，被访问的成员也要公有才可以被访问。
---------------------------------------------------


总结：
    包与包之间进行访问，被访问的包中的类以及类中的成员，需要public修饰。
    不同包中的子类还可以访问直接父类中被protected权限修饰的成员。

包与包之间可以使用的权限只有两种，public protected。

             public   protected   default    private
同一个类中    可以      可以        可以       可以
同一个包中    可以        可以        可以       不可以
子类          可以        可以        不可以     不可以
不同包中      可以      不可以      不可以   不可以
*/
