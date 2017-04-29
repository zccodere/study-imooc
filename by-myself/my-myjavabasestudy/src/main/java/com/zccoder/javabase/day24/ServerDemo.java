package com.zccoder.javabase.day24;
/*
演示客户端和服务端。

1，
客户端：浏览器
服务端：自定义

2，
客户端：浏览器
服务端：Tomcat服务器

3，
客户端：自定义
服务端：Tomcat服务器
*/
import java.net.*;
import java.io.*;
public class  ServerDemo
{
    public static void main(String[] args) throws Exception
    {
        ServerSocket ss = new ServerSocket(11000);

        Socket s = ss.accept();

        String ip = s.getInetAddress().getHostAddress();
        System.out.println(ip+"...connected");
        InputStream in = s.getInputStream();

        byte[] buf = new byte[1024];

        int len = in.read(buf);

        System.out.println(new String(buf,0,len));

        PrintWriter out = new PrintWriter(s.getOutputStream(),true);

        out.println("<font color='red' size='7'>客户端你好</font>");

        s.close();

        ss.close();
    }
}

/*
http://192.168.1.5:11000/myweb/demo.html

GET  /myweb/demo.html HTTP/1.1
Accept: text/html, application/xhtml+xml, 
Referer: http://www.baidu.com/s?wd=192.168.1.5%3A11000&tn=28026190_dg&ie=utf-8
Accept-Language: zh-CN
User-Agent: Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.1; WOW64; Trident/6
.0)
Accept-Encoding: gzip, deflate
Host: 192.168.1.5:11000
DNT: 1
Connection: Keep-Alive
*/
