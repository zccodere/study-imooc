package com.zccoder.javabase.day19;
/*
缓冲区的出现是为了提高流的操作效率而出现的。

所以在创建缓冲区之前，必须要先有流对象。

该缓冲区中提供了一个跨平台的换行符。newLine();
*/
import java.io.*;
public class BufferedWriterDemo 
{
    public static void main(String[] args) throws IOException
    {
        //创建一个字符写入流对象。
        FileWriter fw = new FileWriter("buf.txt");

        //为了提高字符写入流效率。加入了缓冲技术。
        //只要将需要被提高效率的流对象作为参数传递给缓冲区的构造函数即可。
        BufferedWriter bufw = new BufferedWriter(fw);

        for(int x=1;x<5;x++)
        {
            bufw.write("abcd"+x);
            bufw.newLine();
            bufw.flush();
        }

        //记住，只要用到缓冲区，就要记得刷新。
        //bufw.flush();

        //其实关闭缓冲区，就是在关闭缓冲区中的流对象。
        bufw.close();
    }
}
