package com.zccoder.javabase.day16;
/*
map集合的两种取出方式：
1，keySet：将map中所有的键存入到Set集合。因为Set具备迭代器。
    所以可以迭代方式取出所有的键，在根据get方法，获取每一个键对应的值。

    Map集合的取出原理：将map集合转成set集合。在通过迭代器取出。

2，Set<Map.Entry<k,v>> entrySet：将map集合中的映射关系存入到了set集合中，
    而这个关系的数据类型就是：Map.Entry。
*/
import java.util.*;
class MapDemo2 
{
    public static void main(String[] args) 
    {
        Map<String,String> map = new HashMap<String,String>();

        map.put("02","zhangsan2");
        map.put("03","zhangsan3");
        map.put("01","zhangsan1");
        map.put("04","zhangsan4");

        //将Map集合中的映射关系取出，存入到Set集合中。
        Set<Map.Entry<String,String>> entrySet = map.entrySet();
        Iterator<Map.Entry<String,String>> it = entrySet.iterator();
        while(it.hasNext())
        {
            Map.Entry<String,String> me=it.next();
            String key= me.getKey();
            String value = me.getValue();
            System.out.println("key:"+key+",value:"+value);
        }

        /*
        //先获取map集合的所有键的Set集合，keySet();
        Set<String> keySet = map.keySet();

        //有了Set集合，就可以获取其迭代器。
        Iterator<String> it = keySet.iterator();

        while(it.hasNext())
        {
            String key = it.next();
            //有了键可以通过map集合的get方法获取其对应的值。
            String value = map.get(key);
            System.out.println("key:"+key+",value:"+value);
        }
        */
    }
}

/*
Map.Entey 其实Entry也是一个接口，它是Map接口中的一个内部接口。
*/

//interface Map
//{
//    public static interface Entry
//    {
//        public abstract Object getKey();
//        public abstract Object getValue();
//    }
//}
//
//class HashMap implements Map
//{
//    class Haha implements Map.Entry
//    {
//        public  Object getKey(){}
//        public  Object getValue(){}
//    }    
//}
