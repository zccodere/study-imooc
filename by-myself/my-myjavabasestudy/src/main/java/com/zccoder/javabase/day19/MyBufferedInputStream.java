package com.zccoder.javabase.day19;
import java.io.*;

public class MyBufferedInputStream 
{
    private InputStream in;
    
    private byte[] buf = new byte[1024*4];

    private int pos = 0,count = 0;

    MyBufferedInputStream(InputStream in)
    {
        this.in = in;
    }

    //一次读一个字节，从缓冲区（字节数组）获取。
    public int myRead()throws IOException
    {
        //通过in对象读取硬盘上数据，并存储buf中。
        if(count==0)
        {
            count = in.read(buf);
            if(count<0)
                return -1;
            pos = 0;
            byte b = buf[pos];

            count--;
            pos++;
            return b&255;
        }
        else if(count>0)
        {
            byte b = buf[pos];

            count--;
            pos++;
            return b&0xff;
        }
        return -1;
        
    }

    public void myClose()throws IOException
    {
        in.close();
    }
}

/*
11111111-111111111110101011101101010101010100100000101010010

byte: -1  --->   int : -1;
00000000 00000000 00000000 11111111 255

11111111 11111111 11111111 11111111

11111111  --->提升了一个int类型 那不还是-1吗？是-1的原因是因为在8个1前面补的是1导致的。
那么我只要在前面补0，既可以保留原字节数据不变，又可以避免-1的出现。
怎么补0呢？
11111111 11111111 11111111 11111111
00000000 00000000 00000000 11111111
-------------------------------------
00000000 00000000 00000000 11111111

*/
