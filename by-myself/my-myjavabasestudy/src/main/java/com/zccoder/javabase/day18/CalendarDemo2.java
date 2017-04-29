package com.zccoder.javabase.day18;
/*
两个练习：
1，获取任意年的二月有多少天。
    思路：根据指定年设置一个时间就是 
    c.set(year,2,1)//某一年的3月1日。
    c.add(Calendar.DAY_OF_MONTH,-1);//3月1日，往前推一天，就是2月最后一天。

2，获取昨天的现在这个时刻。
    c.add(Calendar.DAY_OF_MONTH,-1);
*/
import java.util.*;
class CalendarDemo2 
{
    public static void main(String[] args) 
    {
        Calendar c=Calendar.getInstance();

        //c.set(2012,2,22);

        c.add(Calendar.MONTH,-1);
        printCalendar(c);
    }
    public static void printCalendar(Calendar c)
    {

        String[] mons = {"一月","二月","三月","四月",
                         "五月","六月","七月","八月",
                         "九月","十月","十一月","十二月"};

        String[] weeks = {"","星期七","星期一","星期二",
                "星期三","星期四","星期五","星期六"};
        
        int index=c.get(Calendar.MONTH);
        int index1=c.get(Calendar.DAY_OF_WEEK);



        sop(c.get(Calendar.YEAR)+"年");
        //sop((c.get(Calendar.MONTH)+1)+"月");
        sop(mons[index]);

        //sop(c.get(Calendar.DAY_OF_MONTH)+"日");
        sop("星期"+c.get(Calendar.DAY_OF_WEEK));
        sop(weeks[index1]);
    }
    public static void sop(Object obj)
    {
        System.out.println(obj);
    }
}
