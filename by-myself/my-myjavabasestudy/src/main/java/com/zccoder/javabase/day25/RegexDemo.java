package com.zccoder.javabase.day25;
/*
正则表达式：符合一定规则的表达式。
    作用：用于专门操作字符串。
    特点：用一些特定的符号来表示一些代码操作。这样就简化了书写。
    所以学习正则表达式，就是在学习一些特殊符号的使用。

    好处：可以简化对字符串的复杂操作。
    弊端：符号定义越多，正则越长，阅读性越差。

具体操作功能：
1，匹配：String matchess();方法。用规则匹配整个字符串，只要有一处不符合规则，就匹配结束，返回false。

2，切割：String split();

3，替换：String replaceAll();
*/
public class RegexDemo 
{
    @SuppressWarnings("unused")
    public static void main(String[] args) 
    {
        //demo();
        //System.out.println(0x0b);
        //checkTel();
        //splitDemo();
        //splitDemo("zhangsan.lisi.wangwu","\\.");
        //splitDemo("c\\abc\\a.txt","\\\\");

        //splitDemo("erkktykkuio","(.)\\1+");//按照叠词完成切割。为了可以让规则的结果被重用。
                                        //可以将规则封装成一个组。用()完成。组的出现都有编号。
                                        //从1开始。想要使用已有的组可以通过 \n(n就是组的编号) 的形式来获取。
        String str = "wei12345454545ty34uiod2345f";//将字符串中的数字替换成#。
        //replaceAllDemo(str,"\\d{5,}","#");

        String str1 = "erkktykkuizzzzo";//将叠词替换成$号。//将重叠的字符替换成单个字母。zzzz->z
        replaceAllDemo(str1,"(.)\\1+","$1");
    }
    
    public static void replaceAllDemo(String str,String reg,String newStr)
    {
        str = str.replaceAll(reg,newStr);
        System.out.println(str);
    }


    public static void splitDemo(String str,String reg)
    {
        //String reg = " +";//按照多个空格来进行切割
        
        String[] arr = str.split(reg);
        System.out.println(arr.length);
        for(String s : arr)
        {
            System.out.println(s);
        }
    }

    /*
    匹配
    手机号段只有13xxx 15xxx 18xxx
    */
    public static void checkTel()
    {
        String tel = "13900000011";
        String telReg = "1[358]\\d{9}";
        System.out.println(tel.matches(telReg));
    }

    public static void demo()
    {
        String str = "b333332";

        String reg = "[a-zA-Z]\\d*";

        boolean b = str.matches(reg);
        System.out.println(b);
    }
    public static void checkQQ()
    {
        String qq = "123456";

        String reger = "[1-9]\\d{4,14}";

        boolean flag = qq.matches(reger);
        if(flag)
            System.out.println(qq+"...is ok");
        else
            System.out.println(qq+"...不合法");

    }

    /*
    对QQ号码进行校验
    要求：5~15  0不能开头，只能是数字
    这种方式，使用了String类中的方法，进行组合完成了需求。但是代码过去复杂。
    */
    @SuppressWarnings("unused")
    public static void checkQQ_1()
    {
        String qq = "1882345";

        int len = qq.length();

        if(len>=5 && len<=15)
        {
            if(!qq.startsWith("0"))//Integer.parseInt("12a");NunmbeFormatException
            {
                try
                {
                    long l = Long.parseLong(qq);
                    System.out.println("qq:"+qq);
                }
                catch (NumberFormatException e)
                {
                    System.out.println("出现非法字符");
                }

                
                /*
                char[] arr = qq.toCharArray();//123a4
                boolean flag = true;
                for(int x=0;x<arr.length;x++)
                {
                    if(!(arr[x]>='0' && arr[x]<='9'))
                    {
                        flag = false;
                        break;
                    }
                }
                if(flag)
                {
                    System.out.println("qq:"+qq);
                }
                else
                {
                    System.out.println("出现非法字符");
                }
                */
            }
            else
            {
                System.out.println("不可以0开头");
            }
        }
        else
        {
            System.out.println("长度错误");
        }
    }
}
