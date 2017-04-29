package com.zccoder.javabase.day25;
import java.util.regex.*;
import java.io.*;
import java.net.*;

public class  RegexTest2
{
    public static void main(String[] args) throws Exception
    {
        getMails_1();
    }
    public static void getMails_1()throws Exception
    {
        URL url = new URL("http://tieba.baidu.com/p/4117828178");

        URLConnection conn = url.openConnection();

        BufferedReader bufIn = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        
        String line = null;

        String mailreg = "\\w+@\\w+(\\.\\w+)+";
        Pattern p = Pattern.compile(mailreg);

        while((line=bufIn.readLine())!=null)
        {
            Matcher m = p.matcher(line);
            while(m.find())
            {
                System.out.println(m.group());
            }
        }
    }    
    /*
    获取指定文档中的邮件地址。
    使用获取功能，Pattern  Matcher
    */
    @SuppressWarnings("resource")
    public static void getMails()throws Exception    
    {
        BufferedReader bufr = 
            new BufferedReader(new FileReader("mail.txt"));

        String line = null;

        String mailreg = "\\w+@\\w+(\\.\\w+)+";
        Pattern p = Pattern.compile(mailreg);

        while((line=bufr.readLine())!=null)
        {
            Matcher m = p.matcher(line);
            while(m.find())
            {
                System.out.println(m.group());
            }
        }
    }
}
