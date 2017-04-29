package com.zccoder.javabase.day24;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
public class MyIEByGUI 
{
    private Frame f;
    private TextField tf;
    private Button but;
    private TextArea ta;

    private Dialog d;
    private Label lab;
    private Button okBut;

    MyIEByGUI()
    {
        init();
    }

    public void init()
    {
        f = new Frame("my window");
        f.setBounds(300,100,600,500);
        f.setLayout(new FlowLayout());

        tf = new TextField(60);
        but = new Button("转到");
        ta = new TextArea(25,70);

        d = new Dialog(f,"提示信息-seif",true);
        d.setBounds(400,200,240,150);
        d.setLayout(new FlowLayout());
        lab = new Label();
        okBut = new Button("确定");

        d.add(lab);
        d.add(okBut);

        f.add(tf);
        f.add(but);
        f.add(ta);

        myEvent();
        f.setVisible(true);
    }
    private void myEvent()
    {
        okBut.addActionListener(new ActionListener()//提示框确定按钮事件
        {
            public void actionPerformed(ActionEvent e)
            {
                d.setVisible(false);
            }
        });
        d.addWindowListener(new WindowAdapter()//关闭提示框
        {
            public void windowClosing(WindowEvent e)
            {
                d.setVisible(false);
            }
        });
        
        tf.addKeyListener(new KeyAdapter()//从键盘获取数字
        {
            public void keyPressed(KeyEvent e)
            {
                try
                {
                    if(e.getKeyCode()==KeyEvent.VK_ENTER)
                        showDir();
                }
                catch (Exception ex)
                {
                }
                
            }
        });

        but.addActionListener(new ActionListener()//按钮事件
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    showDir();
                }
                catch (Exception ex)
                {
                }
                
            }
        });

        f.addWindowListener(new WindowAdapter()//程序主窗口关闭
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
    }

    public void showDir()throws Exception
    {
        ta.setText("");
        String url = tf.getText();//http://192.168.1.5:8080/myweb/demo.html
        
        int index1 = url.indexOf("//")+2;

        int index2 = url.indexOf("/",index1);

        String str = url.substring(index1,index2);
        String[] arr = str.split(":");
        String host = arr[0];
        int port = Integer.parseInt(arr[1]);
        String path = url.substring(index2);
        //ta.setText(str+"..."+path);

        Socket s = new Socket(host,port);

        PrintWriter out = new PrintWriter(s.getOutputStream(),true);

        out.println("GET "+path+" HTTP/1.1");
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
            ta.append(line+"\f\n");
        }
        s.close();
    }

    public static void main(String[] args) 
    {
        new MyIEByGUI();
    }
}
