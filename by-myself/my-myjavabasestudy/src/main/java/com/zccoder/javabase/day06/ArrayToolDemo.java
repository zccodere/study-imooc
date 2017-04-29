package com.zccoder.javabase.day06;
public class ArrayToolDemo 
{
    public static void main(String[] args) 
    {
        int[] arr={3,1,87,32,8};
        int max=ArrayTool.getMax(arr);
        System.out.println("max="+max);
        
        /*
        ArrayTool tool=new ArrayTool();
        
        int max=tool.getMax(arr);
        System.out.println("max="+max);
        
        int min=tool.getMin(arr);
        System.out.println("min="+min);
        
        tool.printArray(arr);
        tool.selectSort(arr);
        tool.printArray(arr);

        int[] arr1={};
        */
    }
}
