package com.zccoder.javabase.day22;
import java.awt.*;
import java.awt.event.*;
public class MyMenuDemo 
{
    private Frame f;
    private MenuBar mb;
    private Menu m,subMenu;
    private MenuItem closeItem,subItem;

    MyMenuDemo()
    {
        init();
    }
    public void init()
    {
        f = new Frame("my window");
        f.setBounds(300,100,500,600);
        f.setLayout(new FlowLayout());

        mb = new MenuBar();
        m = new Menu("文件");

        subMenu = new Menu("子菜单");
        subItem = new MenuItem("子条目");
        closeItem = new MenuItem("退出");
        
        subMenu.add(subItem);

        m.add(subMenu);
        m.add(closeItem);
        mb.add(m);

        f.setMenuBar(mb);

        myEvent();

        f.setVisible(true);
    }
    private void myEvent()
    {
        closeItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
        f.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) 
    {
        new MyMenuDemo();
    }
}
