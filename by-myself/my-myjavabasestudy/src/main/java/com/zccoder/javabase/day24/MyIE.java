package com.zccoder.javabase.day24;

import java.io.*;
import java.net.*;
public class MyIE 
{
    public static void main(String[] args) throws Exception
    {
        Socket s = new Socket("192.168.1.5",8080);

        PrintWriter out = new PrintWriter(s.getOutputStream(),true);

        out.println("GET /myweb/demo.html HTTP/1.1");
        out.println("Accept: */*");
        out.println("Accept-Language: zh-CN");
        out.println("Host: 192.168.1.5:11000");
        out.println("Connection: closed");

        out.println();
        out.println();

        BufferedReader bufr = new BufferedReader(new InputStreamReader(s.getInputStream()));

        String line = null;
        while((line=bufr.readLine())!=null)
        {
            System.out.println(line);
        }
        s.close();

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
