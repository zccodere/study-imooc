package com.myimooc.java.design.pattern.adapter;

/**
 * 笔记本电脑
 *
 * @author zc 2017-08-29
 */
class NoteBook {

    /**
     * 期望使用三相插座进行充电
     */
    private ThreePlug plug;

    NoteBook(ThreePlug plug) {
        this.plug = plug;
    }

    /**
     * 使用插座进行充电
     */
    void charge() {
        plug.powerWithThree();
    }
}
