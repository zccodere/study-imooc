package com.myimooc.thread.ticket.thread;

/**
 * 使用 Thread 创建线程
 *
 * @author zc 2017-07-08
 */
public class MyThread extends Thread {

    /**
     * 一共有5张火车票
     */
    private int ticketsCont = 5;
    /**
     * 窗口，也即是线程的名字
     */
    private String name;

    MyThread(String name) {
        this.name = name;
    }

    /**
     * 写买票逻辑
     */
    @Override
    public void run() {
        while (ticketsCont > 0) {
            // 如果还有票，就卖掉一张
            ticketsCont--;
            System.out.println(name + "卖了1张票，剩余票数为：" + ticketsCont);
        }
    }
}
