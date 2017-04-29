package com.zccoder.javabase.day21;
/*
编码：字符串变成字节数组。

解码：字节数组变成字符串。

String-->byte[];    str.getBytes(charsetName);

byte[]-->String;    new String(byte[],charsetName);

*/
import java.util.*;
public class EncodeDemo 
{
    public static void main(String[] args) throws Exception
    {
        String s = "哈哈";

        byte[] b1 = s.getBytes("GBK");
        
        System.out.println(Arrays.toString(b1));
        String s1 = new String(b1,"UTF-8");
        System.out.println("s1="+s1);

        //对s1进行iso8859-1编码。

        byte[] b2 = s1.getBytes("UTF-8");
        System.out.println(Arrays.toString(b2));

        String s2 = new String(b2,"GBK");

        System.out.println("s2="+s2);
    }
}
