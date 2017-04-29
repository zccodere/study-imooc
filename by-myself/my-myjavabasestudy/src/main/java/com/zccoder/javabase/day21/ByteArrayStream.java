package com.zccoder.javabase.day21;
/*
用于操作字节数组的流对象。
ByteArrayInputStream ：在构造的时候，需要接收数据源，而且数据源是一个字节数组。
ByteArrayOutputStream ：在构造的时候，不用定义数据目的，因为该对象中已经内部封装了可变长度的字节数组。
这就是数据目的地。

因为这两个流对象都操作的数组，并没有使用系统资源。
所以，不用进行close关闭。

在流操作规律讲解时：

源设备：
    键盘 System.in，硬盘 FileStream，内存 ArrayStream。
目的设备：
    控制台 System.out，硬盘 FileStream，内存 ArrayStream。

用流的读写思想来操作数组。
*/
import java.io.*;
public class ByteArrayStream 
{
    public static void main(String[] args) 
    {
        //数据源。
        ByteArrayInputStream bis = new ByteArrayInputStream("ABCDEFD".getBytes());

        //数据目的。
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        int by = 0;

        while((by=bis.read())!=-1)
        {
            bos.write(by);
        }

        System.out.println(bos.size());
        System.out.println(bos.toString());

        // bos.writeTo(new FileOutputStream("a.txt"));
    }
}
