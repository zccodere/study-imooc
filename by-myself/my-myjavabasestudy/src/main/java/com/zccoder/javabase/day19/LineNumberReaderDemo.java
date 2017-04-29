package com.zccoder.javabase.day19;
import java.io.*;
public class LineNumberReaderDemo 
{
    public static void main(String[] args) throws IOException
    {
        FileReader fr = new FileReader("PersonDemo.java");
        LineNumberReader lnr = new LineNumberReader(fr);

        String line = null;
        lnr.setLineNumber(100);
        while((line=lnr.readLine())!=null)
        {
            System.out.println(lnr.getLineNumber()+":"+line);
        }
        lnr.close();
    }
}

//练习：模拟一个带号的缓冲区对象。
