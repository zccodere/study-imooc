package com.zccoder.javabase.day17;
//package com.zccodere.study.byself.javabasestudy.day17;
//import java.util.*;
//class StrComparator implements Comparator<String>
//{
//    public int compare(String s1,String s2)
//    {
//        /*
//        int num=s1.compareTo(s2);
//        if (num>0)
//        {
//            return -1;
//        }
//        if (num<0)
//        {
//            return 1;
//        }
//        return num;
//        */
//
//        return s2.compareTo(s1);
//    }
//}
//class StrLenComparator implements Comparator<String>
//{
//    public int compare(String s1,String s2)
//    {
//        if(s1.length()>s2.length())
//            return 1;
//        if(s1.length()<s2.length())
//            return -1;
//        return s1.compareTo(s2);
//    }
//}
//class CollectionsDemo2 
//{
//    public static void main(String[] args) 
//    {
//        orderDemo();
//    }
//    
//    @SuppressWarnings("rawtypes")
//    public static void orderDemo()
//    {
//        TreeSet<String> ts = new TreeSet<String>(Collections.reverseOrder(new StrLenComparator()));
//
//        ts.add("abcde");
//        ts.add("aaa");
//        ts.add("k");
//        ts.add("cc");
//
//        Iterator it = ts.iterator();
//        while(it.hasNext())
//        {
//            sop(it.next());
//        }
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//    public static void replaceAllDemo()
//    {
//        List<String> list = new ArrayList<String>();
//
//        list.add("abcd");
//        list.add("aaa");
//        list.add("zz");
//        list.add("kkkkk");
//        
//        sop(list);
//        Collections.replaceAll(list,"aaa","pp");
//        sop(list);
//        Collections.reverse(list);
//
//        sop(list);
//    }
//
//    /*
//    练习。fill方法可以将list集合中所有元素替换成指定元素。
//        将list集合中部分元素替换成指定元素。
//    */
//    public static void fillDemo()
//    {
//        List<String> list = new ArrayList<String>();
//
//        list.add("abcd");
//        list.add("aaa");
//        list.add("zz");
//        list.add("kkkkk");
//        
//        sop(list);
//        Collections.fill(list,"pp");
//        sop(list);
//    }
//    public static void sop(Object obj)
//    {
//        System.out.println(obj);
//    }
//}
