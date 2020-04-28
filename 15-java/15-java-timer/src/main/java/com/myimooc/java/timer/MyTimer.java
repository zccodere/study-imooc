package com.myimooc.java.timer;

import java.text.SimpleDateFormat;
import java.util.Timer;

/**
 * 定时调度类
 * <p>Timer 已经过时，如想要查看运行效果，放开下面注释即可</p>
 *
 * @author zc 2017-05-24
 */
public class MyTimer {

    public static void main(String[] args) {
/*

        // 创建一个 Timer 实例
        Timer timer = new Timer();

        // 创建一个 MyTimerTask 实例
        MyTimerTask myTimerTask = new MyTimerTask("No.1");

        // 通过 Timer 定时定频率调用 MyTimerTask 的业务逻辑
        // 即第一次执行是在当前时间的两秒之后，之后每隔一秒钟执行一次
        timer.schedule(myTimerTask, 2000L);

        System.out.println("schedule time is " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(myTimerTask.scheduledExecutionTime()));
*/

        /*
         * 获取当前时间，并设置成距离当前时间三秒之后的时间
         * 如当前时间是2016-11-10 23:59:57
         * 则设置后的时间则为2016-11-11 00:00:00
         */
        // Calendar calendar = Calendar.getInstance();
        // 定义日期格式
        // SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // System.out.println("Current exec time is : " + simpleDateFormat.format(calendar.getTime()));
        // calendar.add(Calendar.SECOND, 3);

        // schedule的四种用法
        /*
         * 1.在时间等于或超过time的时候执行仅且执行一次task
         *   如在2016-11-11 00:00:00执行一次task，打印任务名字
         */
        // myTimerTask.setName("schedule1");
        // timer.schedule(myTimerTask,calendar.getTime());

        /*
         * 2.时间等于或超过time首次执行task
         *   之后每隔period毫秒重复执行一次task
         *   如在2016-11-11 00:00:00第一次执行task，打印任务名字
         *   之后每隔两秒执行一次task
         */
        // myTimerTask.setName("schedule2");
        // timer.schedule(myTimerTask,calendar.getTime(),2000L);

        /*
         * 3.等待delay毫秒后仅执行且执行一个task
         *   如现在是2016-11-11 00:00:00
         *   则在2016-11-11 00:00:01执行一次task，打印任务名字
         */
        // myTimerTask.setName("schedule3");
        // timer.schedule(myTimerTask,1000L);

        /*
         * 4.等到delay毫秒后首次执行task
         *   之后每隔period毫秒重复执行一次task
         *   如现在是2016-11-11 00:00:00
         *   则在2016-11-11 00:00:01第一次执行task，打印任务名字
         *   之后每隔两秒执行一次task
         */
        // myTimerTask.setName("schedule4");
        // timer.schedule(myTimerTask,1000L,2000L);

        // scheduleAtFixedRate的两种用法
        /*
         * 1.时间等于或超过time时首次执行task
         *   之后每隔period毫秒重复执行一次task
         *   如在2016-11-11 00:00:00第一次执行task，打印任务名字
         *   之后每隔两秒执行一次task
         */
        // myTimerTask.setName("scheduleAtFixedRate1");
        // timer.scheduleAtFixedRate(myTimerTask,calendar.getTime(),2000L);

        /*
         * 2.等待delay毫秒后首次执行task
         *   之后每隔period毫秒重复执行一次task
         *   如现在是2016-11-11 00:00:00
         *   则在2016-11-11 00:00:01第一次执行task，打印任务名字
         *   之后每隔两秒执行一次task
         */
        // myTimerTask.setName("scheduleAtFixedRate2");
        // timer.scheduleAtFixedRate(myTimerTask,1000L,2000L);
    }
}
