package com.myimooc.thread.ticket.runnable;

/**
 * 使用 Runnable 创建线程
 *
 * @author zc 2017-07-08
 */
public class MyThread implements Runnable {

    /**
     * 一共有5张火车票
     */
    private int ticketsCont = 5;

    /**
     * 写买票逻辑
     */
    @Override
    public void run() {
        while (ticketsCont > 0) {
            // 如果还有票，就卖掉一张
            ticketsCont--;
            System.out.println(Thread.currentThread().getName() + "卖了1张票，剩余票数为：" + ticketsCont);
        }
    }
}
