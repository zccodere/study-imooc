package com.zccoder.javabase.day22;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class  MyWindowDemo
{
    private Frame f;
    private TextField tf;
    private Button but;
    private TextArea ta;

    private Dialog d;
    private Label lab;
    private Button okBut;

    MyWindowDemo()
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
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    showDir();
            }
        });

        but.addActionListener(new ActionListener()//按钮事件
        {
            public void actionPerformed(ActionEvent e)
            {
                showDir();
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

    public void showDir()
    {
        String dirPath = tf.getText();
                
        File dir = new File(dirPath);
        if(dir.exists() && dir.isDirectory())
        {
            ta.setText("");
            String[] names = dir.list();
            for(String name : names)
            {
                ta.append(name+"\r\n");
            }
        }
        else
        {
            String info = "您输入的信息："+dirPath+"是错误的。请重输";
            lab.setText(info);
            d.setVisible(true);
        }

        tf.setText("");
    }

    public static void main(String[] args) 
    {
        new MyWindowDemo();
    }
}
