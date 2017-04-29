package com.zccoder.javabase.day19;
/*
演示mp3的复制。通过缓冲区。
BufferedOutputStream
BufferedInputStream
*/

import java.io.*;
public class CopyMp3 
{
    public static void main(String[] args) throws IOException
    {
        long start = System.currentTimeMillis();
        copy_2();
        long end = System.currentTimeMillis();

        System.out.println((end-start)+"毫秒");
    }

    public static void copy_2()throws IOException
    {
        MyBufferedInputStream bufis = new MyBufferedInputStream(new FileInputStream("c:\\0.mp3"));
        BufferedOutputStream bufos = new BufferedOutputStream(new FileOutputStream("c:\\2.mp3"));
        
        int by=0;

        //System.out.println("第一个字节:"+bufis.myRead());

        while((by=bufis.myRead())!=-1)
        {
            bufos.write(by);
        }
        
        bufos.close();
        bufis.myClose();
    }

    //通过字节流的缓冲区完成复制。
    public static void copy_1()throws IOException
    {
        BufferedInputStream bufis = new BufferedInputStream(new FileInputStream("c:\\0.mp3"));
        BufferedOutputStream bufos = new BufferedOutputStream(new FileOutputStream("c:\\1.mp3"));
        
        int by=0;
        while((by=bufis.read())!=-1)
        {
            bufos.write(by);
        }
        
        bufos.close();
        bufis.close();
    }
}
