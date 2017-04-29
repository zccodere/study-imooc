package com.zccoder.javabase.day19;
import java.io.*;
/*
1，
源：键盘录入。
目的：控制台。

2，需求：想把键盘录入的数据存储到一个文件中。
源：键盘。
目的：文件。

3，需求：想要将一个文件的数据打印在控制台上。
源：文件。
目的：控制台。


流操作的基本规律：
最痛苦的就是流对象有很多，不知道该用哪一个。
通过两个明确来完成。
1，明确源和目的。
    源：输入流。InputStream  Reader。
    目的：输出流。OutputStream  Writer。
2，明确操作的数据是否是纯文本。
    是：字符流。
    不是：字节流。
3，当体系明确后，再明确要使用哪个具体的对象。
    通过设备来进行区分：
    源设备：内存，硬盘，键盘。
    目的设备：内存，硬盘，控制台。



1，需求：将一个文本文件中数据存储到另一个文件中。复制文件。
    源：因为是源，所以使用读取流。InputStream  Reader。
    是不是操作文本文件。
    是！这时就可以选择Reader。
    这样体系就明确了。

    接下来明确要使用该体系中的哪个对象。
    明确设备：硬盘。上一个文件。
    Reader体系中可以操作文件的对象是 FileReader。
    是否需要提高效率：是！。加入Reader体系中缓冲区 BufferedReader。

    FileReader fr = new FileReader("a.txt");
    BufferedReader bufr = new BufferedReader(fr);

    目的：OutputStream  Writer.
    是否是纯文本。
    是！Writer。
    设备：硬盘，一个文件。
    Writer体系中可以操作文件的对象FileWriter。
    是否需要提高效率：是！。加入Writer体系中缓冲区 BufferedWriter。

    FileWriter fw = new FileWriter("b.txt");
    BufferedWriter bufw = new BufferedWriter(fw);

练习：将一个图片文件中数据存储到另一个文件中。复制文件，要按照以上格式自己完成三个明确。


-----------------------------------------------

2，需求：将键盘录入的数据保存到一个文件中。
    这个需求中有源和目的都存在。
    那么分别分析：
    源：InputStream  Reader。
    是不是纯文本？是！Reader。
    设备：键盘。对应的对象是System.in。
    不是选择Reader吗？System.in对应的不是字节流吗？
    为了操作键盘的文本数据方便。转成字符流按照字符串操作时最方便的。
    所有既然明确了Reader，那么就将System.in转换成Reader。
    用了Reader体系中转换流，InputStreamReader。

    InputStreamReader isr = new InputStreamReader(System.in);

    需要提高效率吗？需要！BufferedReader。
    BufferedReader bufe = new BufferedReader(isr);

    目的：OutputStream  Writer。
    是否是纯文本？是！Writer。
    设备：硬盘，一个文件。使用FileWriter。
    FileWriter fw = new FileWriter("c.txt");

    需要提高效率吗？需要。
    BufferedWriter bufw = new BufferedWriter(fw);

    ***********************************
    扩展一下：想要把录入的数据按照指定的编码表（utf-8），将数据存到文件中。

    目的：OutputStream  Writer。
    是否是纯文本？是！Writer。
    设备：硬盘，一个文件。使用FileWriter。
        但是FileWriter是使用的默认编码表。GBK。

    但是存储时，需要加入指定编码表utf-8。而指定编码表只有转换流可以指定，
    所以要使用的对象是OutputStreamWriter。
    而该转换流对象要接收一个字节输出流。而且还可以操作的文件的字节输出流。FileOutputStream。

    OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("d.txt","UTF-8"));

    需要高效吗？需要。
    BufferedWriter bufw = new BufferedWriter(osw);

    所以，记住。转换流什么时候使用？字符和字节之间的桥梁，通常，涉及到字符编码转换时，
    需要用到转换流。

练习：将一个文本数据打印在控制台上。要按照以上格式自己完成三个明确。

*/
public class TransStreamDemo2 
{
    public static void main(String[] args) throws IOException
    {
        System.setIn(new FileInputStream("PersonDemo.java"));

        System.setOut(new PrintStream("zz.txt"));

        //键盘录入最常见写法。
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));


        BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line =null;

        while((line = bufr.readLine())!=null)
        {
            if("over".equals(line))
                break;
            bufw.write(line.toUpperCase());
            bufw.newLine();
            bufw.flush();
        }

        bufr.close();
    }
}
