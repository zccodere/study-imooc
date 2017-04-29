package com.zccoder.javabase.day20;
import java.io.*;
import java.util.*;
public class SplitFile 
{
    public static void main(String[] args) throws IOException
    {
        //splitFile();
        merge();
    }

    public static void merge()throws IOException
    {
        ArrayList<FileInputStream> al = new ArrayList<FileInputStream>();

        for(int x=1;x<=5;x++)
        {
            al.add(new FileInputStream("c:\\splitfiles\\"+x+".part"));
        }

        final Iterator<FileInputStream> it = al.iterator();
        
        Enumeration<FileInputStream> en = new Enumeration<FileInputStream>()
        {
            public boolean hasMoreElements()
            {
                return it.hasNext();
            }
            public FileInputStream nextElement()
            {
                return it.next();
            }
        };

        SequenceInputStream sis = new SequenceInputStream(en);

        FileOutputStream fos = new FileOutputStream("c:\\splitfiles\\0.mp3");

        byte[] buf = new byte[1024*1024];

        int len=0;

        while((len=sis.read(buf))!=-1)
        {
            fos.write(buf,0,len);
        }

        fos.close();
        sis.close();
    }

    public static void splitFile()throws IOException
    {
        FileInputStream fis = new FileInputStream("c:\\1.mp3");

        FileOutputStream fos = null;
        byte[] buf = new byte[1024*1024];

        int len = 0;
        int count = 1;

        while((len=fis.read(buf))!=-1)
        {
            fos = new FileOutputStream("c:\\splitfiles\\"+(count++)+".part");
            fos.write(buf,0,len);
            fos.close();
        }

        fis.close();
    }
}
