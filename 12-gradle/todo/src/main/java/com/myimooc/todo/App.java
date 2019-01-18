package com.myimooc.todo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

/**
 * Created by ZC on 2017/5/16.
 */
public class App {

    private static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args){
        int i = 0;
        Scanner scanner = new Scanner(System.in);
        while(++i>0){
            logger.info(i + ". please input todo item name");
            TodoItem item = new TodoItem(scanner.nextLine());
            System.out.println(item);
        }
    }

}
