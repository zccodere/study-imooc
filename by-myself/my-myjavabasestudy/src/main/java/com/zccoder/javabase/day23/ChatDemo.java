package com.zccoder.javabase.day23;
/*
编写一个聊天程序。
有收数据的部分，和发数据的部分。
这两部分需要同时执行。
那就需要用到多线程技术。
一个线程控制收，一个线程控制发。

因为收和发动作是不一致的，所有要定义两个run方法。
而且这两个方法要放在不同的类中。
*/
import java.net.*;
import java.io.*;
class Send implements Runnable
{
    private DatagramSocket ds;
    public Send(DatagramSocket ds)
    {
        this.ds = ds;
    }
    public void run()
    {
        try
        {
            BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

            String line = null;
            while((line=bufr.readLine())!=null)
            {
                if("886".equals(line))
                    break;
                byte[] buf = line.getBytes();
                DatagramPacket dp = 
                    new DatagramPacket(buf,buf.length,InetAddress.getByName("192.168.1.255"),10002);
                ds.send(dp);
            }
        }
        catch (Exception e)
        {
            throw new RuntimeException("发送端失败");
        }
    }
}

class Rece implements Runnable
{
    private DatagramSocket ds;
    public Rece(DatagramSocket ds)
    {
        this.ds = ds;
    }
    public void run()
    {
        try
        {
            while(true)
            {
                byte[] buf = new byte[1024];
                DatagramPacket dp = new DatagramPacket(buf,buf.length);

                ds.receive(dp);

                String ip = dp.getAddress().getHostAddress();

                String data = new String(dp.getData(),0,dp.getLength());

                System.out.println(ip+":"+data);
            }
        }
        catch (Exception e)
        {
            throw new RuntimeException("接收失败");
        }
    }
}
public class ChatDemo 
{
    public static void main(String[] args) throws Exception
    {
        DatagramSocket sendSocket = new DatagramSocket();
        DatagramSocket receSocket = new DatagramSocket(10002);

        new Thread(new Send(sendSocket)).start();
        new Thread(new Rece(receSocket)).start();
    }
}
