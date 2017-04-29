package com.zccoder.javabase.day20;
/*
删除一个带内容的目录。
删除原理：
在windows中，删除目录从里面往外删除的。

既然是从里往外删除。就需要用到递归。
*/

import java.io.*;
public class RemoveDir 
{
    public static void main(String[] args) 
    {
        File dir = new File("d:\\testdir");
        removeDir(dir);
    }

    public static void removeDir(File dir)
    {
        File[] files = dir.listFiles();

        for(int x=0;x<files.length;x++)
        {
            if(!files[x].isDirectory())
            {
                removeDir(files[x]);
            }
            else
                System.out.println(files[x].toString()+":-file-:"+files[x].delete());
        }

        System.out.println(dir+"::dir::"+dir.delete());
    }
}
