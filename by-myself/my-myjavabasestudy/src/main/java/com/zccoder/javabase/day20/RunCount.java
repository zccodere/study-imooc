package com.zccoder.javabase.day20;
/*
用于记录引用程序运行次数。
如果使用次数已到，那么给出注册提示。

很容易想到的是：计数器。
可是该计数器定义在程序中，随着程序的运行而在内存中存在，并进行了自增。
可是随着该应用程序的退出，该计数器也在内存中消失了。

下一次在启动该程序，有重新开始从0技术。
这样不是我们想要的。

程序即使结束，该计数器的值也存在。
下次程序启动也会先加载该计数器的值并加1后再重新存储起来。

所有要建立一个配置文件。用于记录该软件的使用次数。

该配置文件使用键值对的形式。
这样便于阅读数据，并操作数据。

键值对数据是map集合。
数据是以文件形式存储，使用io技术。
那么map+io  ----->properties。

配置文件可以实现应用程序数据的共享。
*/
import java.io.*;
import java.util.*;
public class  RunCount
{
    public static void main(String[] args) throws IOException
    {
        Properties porp = new Properties();

        File file = new File("count.ini");
        if(!file.exists())
            file.createNewFile();

        FileInputStream fis = new FileInputStream(file);

        porp.load(fis);

        int count = 0;
        String value = porp.getProperty("time");

        if(value!=null)
        {
            count = Integer.parseInt(value);
            if(count>=5)
            {
                System.out.println("您好，使用次数已到，拿钱！");
                return ;
            }
        }

        count++;

        porp.setProperty("time",count+"");

        FileOutputStream fos = new FileOutputStream(file);

        porp.store(fos,"");

        fos.close();
        fis.close();
    }
}
/*
配置文件封装形式：
1、键值对架构
name=zhangsan
sge=20

2、XML架构
<persons>
    <person id="001">
        <name>zhangsan</name>
        <sge>30</age>
        <address>bj</address>
    </person>
    <person>
        <name>
    </person>
</persons>

*/
