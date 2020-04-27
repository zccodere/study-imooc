package com.myimooc.java.sms.runtime;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

/**
 * 程序入口
 *
 * @author zc
 * @date 2018/05/29
 */
public class Main {

    private static final String QUIT_TEXT = "quit";

    public static void main(String[] args) {
        CommandRunner commandRunner = new CommandRunner();
        Scanner scanner = new Scanner(System.in);
        String line;
        while (!Objects.equals((line = scanner.nextLine()), QUIT_TEXT)) {
            String[] inputs = line.split("\\W");
            commandRunner.run(inputs[0], inputs[1], Arrays.asList(Arrays.copyOfRange(inputs, 2, inputs.length)));
        }
    }
}
