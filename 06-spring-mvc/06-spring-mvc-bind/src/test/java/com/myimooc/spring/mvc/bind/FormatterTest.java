package com.myimooc.spring.mvc.bind;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.format.number.CurrencyFormatter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.util.Locale;

/**
 * Created by geely on 2015/11/22.
 */
public class FormatterTest {

    @Test
    public void test1() throws ParseException {
        CurrencyFormatter currencyFormatter = new CurrencyFormatter();
        currencyFormatter.setFractionDigits(2);//����С�����λ
        currencyFormatter.setRoundingMode(RoundingMode.CEILING);//����ģʽ��ceilling��ʾ�������룩
        //1���������ҷ��ŵ��ַ�����$123.125��ת��ΪBigDecimal("123.00")
        Assert.assertEquals(new BigDecimal("123.13"), currencyFormatter.parse("$123.125", Locale.US));
    }
    @Test
    public void test2(){
        CurrencyFormatter currencyFormatter = new CurrencyFormatter();
        currencyFormatter.setFractionDigits(2);//����С�����λ
        currencyFormatter.setRoundingMode(RoundingMode.CEILING);//����ģʽ��ceilling��ʾ�������룩
        //2����BigDecimal("123")��ʽ��Ϊ�ַ�����$123.00��չʾ
        Assert.assertEquals("$123.00", currencyFormatter.print(new BigDecimal("123"), Locale.US));
    }
}
