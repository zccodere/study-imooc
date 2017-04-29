package com.zccoder.javabase.day19;
import java.util.*;
import java.io.*;
public class SystemInfo 
{
    public static void main(String[] args) throws IOException
    {
        Properties prop = System.getProperties();

        //System.out.println(prop);

        prop.list(new PrintStream("sysinfo.txt"));
    }
}
