package com.zccoder.javabase.day03;
public class OtherDemo 
{
    @SuppressWarnings("unused")
    public static void main(String[] args) 
    {
        //break：
        w:for(int x=0;x<3;x++)//for前面W表示用w标号当前for循环。
        {
            q:for(int y=0;y<4;y++)//for前面q表示用w标号当前for循环。
            {
                System.out.println("x="+x);
                break w;//注意：标号只能用于循环语句上，给循环起名字。
            }
        }

        //continue：只能作用于循环结构。继续循环。
        //特点：结束本次循环，继续下一次循环。
        for(int x=0;x<10;x++)
        {
            if(x%2==1)
                continue;
            System.out.println("x="+x);            
        }

        w:for(int x=0;x<3;x++)
        {
            q:for(int y=0;y<4;y++)
            {
                System.out.println("x="+x);
                break w;
            }
        }
        /*
        总结：
        1，break和continue语句作用的范围。
        2，break和continue单独存在时，下面可以有任何语句。因为都执行不到。
        */
    }
}
