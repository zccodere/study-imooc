package com.myimooc.small.advanced.domain.trans;

import java.util.Arrays;

/**
 * 百度翻译API
 *
 * @author zc 2017-08-12
 */
public class Data {

    private String wordName;
    private Symbols[] symbols;

    @Override
    public String toString() {
        return "Data{" +
                "wordName='" + wordName + '\'' +
                ", symbols=" + Arrays.toString(symbols) +
                '}';
    }

    public String getWordName() {
        return wordName;
    }

    public void setWordName(String wordName) {
        this.wordName = wordName;
    }

    public Symbols[] getSymbols() {
        return symbols;
    }

    public void setSymbols(Symbols[] symbols) {
        this.symbols = symbols;
    }
}
