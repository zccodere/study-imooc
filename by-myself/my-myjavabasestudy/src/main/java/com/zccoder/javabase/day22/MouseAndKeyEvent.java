package com.zccoder.javabase.day22;
import java.awt.*;
import java.awt.event.*;
public class MouseAndKeyEvent 
{
    private Frame f;
    private Button but;
    private TextField tf;

    MouseAndKeyEvent()
    {
        init();
    }
    public void init()
    {
        f = new Frame("my frame");
        f.setBounds(300,100,600,500);
        f.setLayout(new FlowLayout());
        
        tf = new TextField(20);

        but = new Button("my button");

        f.add(tf);
        f.add(but);    
        myEvent();
        f.setVisible(true);
    }
    public void myEvent()
    {
        f.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
        
        tf.addKeyListener(new KeyAdapter()
        {
            public void keyPressed(KeyEvent e)
            {
                int code = e.getKeyCode();
                if(!(code>=KeyEvent.VK_0 && code<=KeyEvent.VK_9))
                {    
                    System.out.println(code+"...是非法的");
                    e.consume();
                }
            }
        });

        //给but添加一个键盘监听。
        but.addKeyListener(new KeyAdapter()
        {
            public void keyPressed(KeyEvent e)
            {
                if(e.isControlDown()&&e.getKeyCode()==KeyEvent.VK_ENTER)
                    //System.exit(0);
                    System.out.println("ctrl+enter is run");
                //System.out.println(KeyEvent.getKeyText(e.getKeyCode())+"..."+e.getKeyCode());
            }
        });
        
        /*
        but.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("action ok");
            }
        });
        but.addMouseListener(new MouseAdapter()
        {
            private int count = 1;
            private int clickCount = 1;
            public void mouseFntered(MouseEvent e)
            {
                System.out.println("鼠标进入到该组件"+count++);
            }
            public void mouseClicked(MouseEvent e)
            {
                if(e.getClickCount()==2)
                    System.out.println("双击动作"+clickCount++);
            }
        });
        */
    }

    public static void main(String[] args) 
    {
        new MouseAndKeyEvent();
    }
}
