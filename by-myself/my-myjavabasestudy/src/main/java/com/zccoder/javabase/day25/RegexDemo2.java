package com.zccoder.javabase.day25;
/*
正则表达式的第四个功能。
4，获取：将字符串中的符合规则的子串取出。

操作步骤：
1，将正则表达式封装成对象。
2，让正则对象和要操作的字符串相关联。
3，关联后，获取正则匹配引擎。
4，通过引擎对符合规则的子串进行操作，比如取出。
*/
import java.util.regex.*;

public class RegexDemo2 
{
    public static void main(String[] args) 
    {
        getDemo();
    }
    public static void getDemo()
    {
        String str = "ming tian jiu yao fang jia la,da jia.";
        
        String reg = "\\b[a-z]{3}\\b";

        //将规则封装成对象。
        Pattern p = Pattern.compile(reg);

        //让正则对象和要作用的字符串相关联。获取匹配器对象。
        Matcher m = p.matcher(str);

        //System.out.println(m.matches());//其实String类中的matches方法。用的就是Pattern和matcher对象来完成的。
                                    //只不过被String的方法封装后，用起来较为简单。但是功能却单一。
        
    //    boolean b = m.find();//将规则作用到字符串上，并进行符合规则的子串查找。
    //    System.out.println(b);
    //    System.out.println(m.group());
        
    //    System.out.println(m.matches());

        while(m.find())
        {
            System.out.println(m.group());
            System.out.println(m.start()+"..."+m.end());
        }
    }
}
