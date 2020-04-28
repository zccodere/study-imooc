package com.myimooc.spring.mvc.bind.common;

import org.springframework.format.number.CurrencyStyleFormatter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.util.Locale;

/**
 * 格式转换测试
 *
 * @author zc 2017-02-19
 */
public class FormatterTest {

    public static void main(String[] args) throws Exception {
        FormatterTest test = new FormatterTest();
        test.test1();
        test.test2();
    }

    private void test1() throws ParseException {
        CurrencyStyleFormatter currencyFormatter = new CurrencyStyleFormatter();
        currencyFormatter.setFractionDigits(2);
        currencyFormatter.setRoundingMode(RoundingMode.CEILING);

        BigDecimal parse = currencyFormatter.parse("$123.125", Locale.US);
        BigDecimal decimal = new BigDecimal("123.13");
        System.out.println(decimal.equals(parse));
    }

    private void test2() {
        CurrencyStyleFormatter currencyFormatter = new CurrencyStyleFormatter();
        currencyFormatter.setFractionDigits(2);
        currencyFormatter.setRoundingMode(RoundingMode.CEILING);

        String parse = currencyFormatter.print(new BigDecimal("123"), Locale.US);
        String decimal = "$123.00";
        System.out.println(decimal.equals(parse));
    }
}
