package com.zccoder.javabase.day21;
public class  EncodeDemo2
{
    public static void main(String[] args) throws Exception
    {
        String s = "联通";
        
        byte[] by = s.getBytes("GBK");
        
        for (byte b:by )
        {
            System.out.println(Integer.toBinaryString(b&255));
        }
    }
}
