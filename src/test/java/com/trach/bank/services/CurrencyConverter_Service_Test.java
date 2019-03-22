package com.trach.bank.services;

import com.trach.bank.model.Currency;
import com.trach.bank.dao.coursProvider.CurrencyCourseProviderTest;
import com.trach.bank.dao.coursProvider.CurrencyСourseProvider;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CurrencyConverter_Service_Test {
    private CurrencyConverterServiceImpl converter;
    private CurrencyСourseProvider provider;
    private long countMoney ;
    @Before
    public  void  setUp(){

//        provider = new CurrencyCourseProviderFixerIO("5e25c5e7d04a94f95ded0cb44cdfe6ae","http://data.fixer.io/api/latest");
       provider = new CurrencyCourseProviderTest();
        converter =  new CurrencyConverterServiceImpl(provider);
        countMoney = 132_00;
    }


    //MDL tests convert to X
    @Test
    public void convert_MDL_to_EUR_Test(){

        long usd = converter.convertAtEUR(Currency.MDL, countMoney);
        long expected = (long) ((usd * provider.getCourse(Currency.EUR)));
        long actual = converter.convert(Currency.MDL,Currency.EUR,countMoney);
        assertEquals(expected,actual);

    }

    @Test
    public void convert_MDL_to_RUB_Test(){

        long usd = converter.convertAtEUR(Currency.MDL, countMoney);
        long expected = (long) ((usd * provider.getCourse(Currency.RUB)));
        long actual = converter.convert(Currency.MDL,Currency.RUB,countMoney);
        assertEquals(expected,actual);

    }
    @Test
    public void convert_MDL_to_USD_Test(){

        long usd = converter.convertAtEUR(Currency.MDL, countMoney);
        long expected = (long) ((usd * provider.getCourse(Currency.USD)));
        long actual = converter.convert(Currency.MDL,Currency.USD,countMoney);
        assertEquals(expected,actual);

    }

    @Test
    public void convert_MDL_to_MDL_Test(){
        long expected = countMoney;
        long actual = converter.convert(Currency.MDL,Currency.MDL,countMoney);
        assertEquals(expected,actual);

    }
    @Test
    public void convert_MDL_to_UAH_Test(){
        long usd = converter.convertAtEUR(Currency.MDL, countMoney);
        long expected = (long) ((usd * provider.getCourse(Currency.UAH)));
        long actual = converter.convert(Currency.MDL,Currency.UAH,countMoney);
        assertEquals(expected,actual);

    }
    //END MDL tests convert to X

    //RUB tests convert to X
    @Test
    public void convert_RUB_to_MDL_Test(){

        long usd = converter.convertAtEUR(Currency.RUB, countMoney);
        long expected = (long) ((usd * provider.getCourse(Currency.MDL)));
        long actual = converter.convert(Currency.RUB,Currency.MDL,countMoney);
        assertEquals(expected,actual);

    }
    @Test
    public void convert_RUB_to_EUR_Test(){

        long usd = converter.convertAtEUR(Currency.RUB, countMoney);
        long expected = (long) ((usd * provider.getCourse(Currency.EUR)));
        long actual = converter.convert(Currency.RUB,Currency.EUR,countMoney);
        assertEquals(expected,actual);

    }
    @Test
    public void convert_RUB_to_RUB_Test(){


        long expected = countMoney;
        long actual = converter.convert(Currency.RUB,Currency.RUB,countMoney);
        assertEquals(expected,actual);

    }
    @Test
    public void convert_RUB_to_UAH_Test(){

        long usd = converter.convertAtEUR(Currency.RUB, countMoney);
        long expected = (long) ((usd * provider.getCourse(Currency.UAH)));
        long actual = converter.convert(Currency.RUB,Currency.UAH,countMoney);
        assertEquals(expected,actual);

    }
    @Test
    public void convert_RUB_to_USD_test(){
        long usd = converter.convertAtEUR(Currency.RUB, countMoney);
        long expected = (long) ((usd * provider.getCourse(Currency.USD)));
        long actual = converter.convert(Currency.RUB,Currency.USD,countMoney);
        assertEquals(expected,actual);

    }

    //END RUB tests convert to X

    //UAH tests convert to X
    @Test
    public void convert_UAH_to_EUR_Test(){

        long usd = converter.convertAtEUR(Currency.UAH, countMoney);
        long expected = (long) ((usd * provider.getCourse(Currency.EUR)));
        long actual = converter.convert(Currency.UAH,Currency.EUR,countMoney);
        assertEquals(expected,actual);

    }
    @Test
    public void convert_UAH_to_RUB_Test(){

        long usd = converter.convertAtEUR(Currency.UAH, countMoney);
        long expected = (long) ((usd * provider.getCourse(Currency.RUB)));
        long actual = converter.convert(Currency.UAH,Currency.RUB,countMoney);
        assertEquals(expected,actual);

    }
    @Test
    public void convert_UAH_to_USD_Test(){

        long usd = converter.convertAtEUR(Currency.UAH, countMoney);
        long expected = (long) ((usd * provider.getCourse(Currency.USD)));
        long actual = converter.convert(Currency.UAH,Currency.USD,countMoney);
        assertEquals(expected,actual);

    }
    @Test
    public void convert_UAH_to_UAH_Test(){


        long expected = countMoney;
        long actual = converter.convert(Currency.UAH,Currency.UAH,countMoney);
        assertEquals(expected,actual);

    }
    @Test
    public void convert_UAH_to_MDL_Test(){

        long usd = converter.convertAtEUR(Currency.UAH, countMoney);
        long expected = (long) ((usd * provider.getCourse(Currency.MDL)));
        long actual = converter.convert(Currency.UAH,Currency.MDL,countMoney);
        assertEquals(expected,actual);
    }
    //END UAH tests convert to X


    //USD tests convert to X
    @Test
    public void convert_USD_to_USD_Test(){

        long expected = countMoney;
        long actual = converter.convert(Currency.USD,Currency.USD,countMoney);

        assertEquals(expected,actual);

    }
    @Test
    public void convert_USD_to_MDL_Test(){

        long usd = converter.convertAtEUR(Currency.USD, countMoney);
        long expected = (long) ((usd * provider.getCourse(Currency.MDL)));
        long actual = converter.convert(Currency.USD,Currency.MDL,countMoney);
        assertEquals(expected,actual);
    }
    @Test
    public void convert_USD_to_EUR_Test(){

        long usd = converter.convertAtEUR(Currency.USD, countMoney);
        long expected = (long) ((usd * provider.getCourse(Currency.EUR)));
        long actual = converter.convert(Currency.USD,Currency.EUR,countMoney);
        assertEquals(expected,actual);
    }
    @Test
    public void convert_USD_to_RUB_Test(){

        long usd = converter.convertAtEUR(Currency.USD, countMoney);
        long expected = (long) ((usd * provider.getCourse(Currency.RUB)));
        long actual = converter.convert(Currency.USD,Currency.RUB,countMoney);
        assertEquals(expected,actual);
    }
    @Test
    public void convert_USD_to_UAH_Test(){

        long usd = converter.convertAtEUR(Currency.USD, countMoney);
        long expected = (long) ((usd * provider.getCourse(Currency.UAH)));
        long actual = converter.convert(Currency.USD,Currency.UAH,countMoney);
        assertEquals(expected,actual);
    }

    //END USD tests convert to X

    //EUR tests convert to X
    @Test
    public void convert_EUR_to_USD_Test(){


        long usd = converter.convertAtEUR(Currency.EUR, countMoney);
        long expected = (long) ((usd * provider.getCourse(Currency.USD)));
        long actual = converter.convert(Currency.EUR,Currency.USD,countMoney);
        assertEquals(expected,actual);
    }
    @Test
    public void convert_EUR_to_MDL_Test(){

        long usd = converter.convertAtEUR(Currency.EUR, countMoney);
        long expected = (long) ((usd * provider.getCourse(Currency.MDL)));
        long actual = converter.convert(Currency.EUR,Currency.MDL,countMoney);
        assertEquals(expected,actual);
    }
    @Test
    public void convert_EUR_to_EUR_Test(){

        long expected = countMoney;
        long actual = converter.convert(Currency.EUR,Currency.EUR,countMoney);
        assertEquals(expected,actual);
    }
    @Test
    public void convert_EUR_to_RUB_Test(){

        long usd = converter.convertAtEUR(Currency.EUR, countMoney);
        long expected = (long) ((usd * provider.getCourse(Currency.RUB)));
        long actual = converter.convert(Currency.EUR,Currency.RUB,countMoney);
        assertEquals(expected,actual);
    }
    @Test
    public void convert_EUR_to_UAH_Test(){

        long usd = converter.convertAtEUR(Currency.EUR, countMoney);
        long expected = (long) ((usd * provider.getCourse(Currency.UAH)));
        long actual = converter.convert(Currency.EUR,Currency.UAH,countMoney);
        assertEquals(expected,actual);
    }

    //END EUR tests convert to X




}