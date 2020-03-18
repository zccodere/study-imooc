package com.myimooc.java.design.pattern.adapter;

/**
 * 启动类
 *
 * @author zc 2020-03-18
 */
public class Main {

    public static void main(String[] args) {
        GbTwoPlug two = new GbTwoPlug();
        // 使用二相转三相的适配器
        ThreePlug three = new TwoPlugAdapter(two);
        // 使用三相插座进行充电
        NoteBook nb = new NoteBook(three);
        nb.charge();

        three = new TwoPlugAdapterExtends();
        nb = new NoteBook(three);
        nb.charge();
    }
}
