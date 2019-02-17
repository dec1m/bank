package com.trach.bank.utils;

import com.trach.bank.model.Currency;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CurrencyConverter_Test {
    private CurrencyConverterImpl converter;
    private  CurrencyСourseProvider provider;
    private long countMoney ;
    @Before
    public  void  setUp(){

        provider = new CurrencyСourseProviderTest();
        converter =  new CurrencyConverterImpl(provider);
        countMoney = 1000000 * 100;
    }


    @Test
    public void convertAtUsd_ofRUB_toUSD_test(){

        long expected = (long) ((countMoney / 66.29));
        long actual = converter.convertAtUSD(Currency.RUB, countMoney);

        assertEquals(expected,actual,100);

    }
    @Test
    public void convert_ofMDL_toEUR_Test(){

       long usd = converter.convertAtUSD(Currency.MDL, countMoney);
       long expected = (long) (usd * 0.89);
       long actual = converter.convert(Currency.MDL,Currency.EUR,countMoney);

       assertEquals(expected,actual,100);

    }
    @Test
    public void convert_ofUAH_toEUR_Test(){

        long usd = converter.convertAtUSD(Currency.UAH, countMoney);
        long expected = (long) (usd * 0.89);
        long actual = converter.convert(Currency.UAH,Currency.EUR,countMoney);

        assertEquals(expected,actual,100);

    }
    @Test
    public void convert_ofMDL_toRUB_Test(){

        long usd = converter.convertAtUSD(Currency.MDL, countMoney);
        long expected = (long) (usd * 66.29);
        long actual = converter.convert(Currency.MDL,Currency.RUB,countMoney);

        assertEquals(expected,actual,100);

    }
    @Test
    public void convert_ofUAH_toMDL_Test(){

        long usd = converter.convertAtUSD(Currency.UAH, countMoney);
        long expected = (long) (usd * 17.10);
        long actual = converter.convert(Currency.UAH,Currency.MDL,countMoney);

        assertEquals(expected,actual,100);

    }
    @Test
    public void convert_ofUSD_toUSD_Test(){

        long expected = countMoney;
        long actual = converter.convert(Currency.USD,Currency.USD,countMoney);

        assertEquals(expected,actual);

    }



}
