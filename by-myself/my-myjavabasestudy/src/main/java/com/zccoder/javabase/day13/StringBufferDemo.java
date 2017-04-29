package com.zccoder.javabase.day13;
/*
StringBuffer是字符串缓冲区。

是一个容器。

缓冲区的特点：
1，而且长度是可变化的。
2，可以直接操作多个数据类型。
3，最终会通过toString方法变成字符串。

C create U update R read D delete
1，存储。
    StringBuffer append()：将指定数据作为参数添加到已有数据的结尾处。
    StringBuffer insert(index,数据)：可以将数据插入到指定index位置。
2，删除。
    StringBuffer delete(start,end)：删除缓冲区中的数据，包含start，不包含end。
    StringBuffer deleteCharAt(index)：删除指定index位置的字符。
3，获取。
    char charAt(int index);
    int indexOf(String str);
    int lastIndexOf(String str);
    int length();
    String substring(int start,int end);
4，修改。
    StringBuffer replace(start,end,string);
    void setCharAt(int index,char ch);
5，反转。
    StringBuffer reverse();
6，将缓冲区中指定数据存储到指定字符数组中。
    void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) 

JDK1.5版本之后出现了StringBuilder。

StringBuffer是线程同步。单线程使用StringBuffer效率较低。多线程使用StringBuffer保证了安全性。
StringBuilder是线程不同步。单线程使用StringBuilder提高了效率。多线程使用StringBuilder可能存在安全问题，但可以通过自定义锁来解决安全问题。

以后开发，建议使用StringBuilder。

升级三个因素：
1，提高效率。
2，简化书写。
3，提高安全性。
*/
public class StringBufferDemo 
{
    public static void main(String[] args) 
    {
        //method_update();
        StringBuilder sb=new StringBuilder("abcdef");
        char[] chs=new char[6];
        
        sb.getChars(1,4,chs,1);
        for(int x=0;x<chs.length;x++)
        {
            sop("chs["+x+"]="+chs[x]+";");
        }
    }
    public static void method_update()
    {
        StringBuffer sb=new StringBuffer("abcde");
        //sb.replace(1,4,"java");
        sb.setCharAt(2,'k');
        sop(sb.toString());
    }
    public static void method_del()
    {
        StringBuffer sb=new StringBuffer("abcde");
        //sb.delete(1,3);

        //清空缓冲区。
        //sb.delete(0,sb.length());

        //sb.delete(2,3);
        sb.deleteCharAt(2);
        
        sop(sb.toString());
    }
    public static void method_add()
    {
        StringBuffer sb=new StringBuffer();
        sb.append("abc").append(true).append(34);
        //StringBuffer sb1=sb.append(34);
        //sop("sb==sb1："+(sb==sb1));
        sb.insert(1,"qq");
        sop(sb.toString());//abctrue34
        //sop(sb1.toString());
    }
    public static void sop(String str)
    {
        System.out.println(str);
    }
}
