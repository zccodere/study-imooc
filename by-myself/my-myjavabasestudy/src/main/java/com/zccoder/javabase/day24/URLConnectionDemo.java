package com.zccoder.javabase.day24;
import java.net.*;
import java.io.*;
public class URLConnectionDemo 
{
    public static void main(String[] args) throws Exception
    {
        URL url = new URL("http://192.168.1.5:8080/myweb/demo.html");
        
        URLConnection conn = url.openConnection();

        System.out.println(conn);

        InputStream in = conn.getInputStream();

        byte[] buf = new byte[1024];

        int len = in.read(buf);

        System.out.println(new String(buf,0,len));
        
    }
}
