package com.zccoder.javabase.day19;
/*
明白了BufferedReader类中特有方法readLine的原理后，
可以自定义一个类中包含一个功能和readLine一致的方法。
来模拟一下BufferedReader。
*/
import java.io.*;
class MyBufferedReader extends Reader
{
    private Reader r;
    MyBufferedReader(Reader r)
    {
        this.r=r;
    }
    
    //可以一次读一行数据的方法。
    public String myReadLine()throws IOException
    {
        //定义一个临时容器。原BufferedReader封装的是字符数组。
        //为了演示方便。定义一个StringBuilder容器。因为最终还是要将数据变成字符串。
        StringBuilder sb = new StringBuilder();
        int ch = 0;
        while((ch=r.read())!=-1)
        {
            if(ch=='\r')
                continue;
            if(ch=='\n')
                return sb.toString();
            else
                sb.append((char)ch);
        }
        if(sb.length()!=0)
            return sb.toString();
        return null;
    }
    /*
    覆盖Reader类中的抽象方法
    */
    public int read(char[] cbuf,int off,int len)throws IOException
    {
        return r.read(cbuf,off,len);
    }
    public void close()throws IOException
    {
        r.close();
    }
    public void myClose()throws IOException
    {
        r.close();
    }
}
public class  MyBufferedReaderDemo
{
    @SuppressWarnings("resource")
    public static void main(String[] args) throws IOException
    {
        FileReader fr = new FileReader("buf.txt");

        MyBufferedReader myBuf = new MyBufferedReader(fr);

        String line = null;

        while((line=myBuf.myReadLine())!=null)
        {
            System.out.println(line);
        }
        myBuf.myClose();
    }
}
