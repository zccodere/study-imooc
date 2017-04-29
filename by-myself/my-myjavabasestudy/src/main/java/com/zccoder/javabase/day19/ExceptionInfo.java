package com.zccoder.javabase.day19;
import java.io.*;
import java.util.*;
import java.text.*;
public class ExceptionInfo 
{
    public static void main(String[] args) throws IOException
    {
        try
        {
            int[] arr = new int[2];
            System.out.println(arr[3]);
        }
        catch (Exception e)
        {
            try
            {
                Date d = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String s = sdf.format(d);

                PrintStream ps = new PrintStream("exception.log");
                ps.println(s.toString());
                System.setOut(ps);
            }
            catch (IOException ex)
            {
                throw new RuntimeException("日志文件创建失败");
            }
            
            e.printStackTrace(System.out);
        }
    }
}

//log4j
