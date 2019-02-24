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

        provider = new CurrencyCourseProviderTest();
        converter =  new CurrencyConverterImpl(provider);
        countMoney = 132_00;
    }


    //MDL tests convert to X
    @Test
    public void convert_MDL_to_EUR_Test(){

        long usd = converter.convertAtUSD(Currency.MDL, countMoney);
        long expected = (long) ((usd * provider.getCource(Currency.EUR)));
        long actual = converter.convert(Currency.MDL,Currency.EUR,countMoney);
        assertEquals(expected,actual);

    }

    @Test
    public void convert_MDL_to_RUB_Test(){

        long usd = converter.convertAtUSD(Currency.MDL, countMoney);
        long expected = (long) ((usd * provider.getCource(Currency.RUB)));
        long actual = converter.convert(Currency.MDL,Currency.RUB,countMoney);
        assertEquals(expected,actual);

    }
    @Test
    public void convert_MDL_to_USD_Test(){

        long usd = converter.convertAtUSD(Currency.MDL, countMoney);
        long expected = (long) ((usd * provider.getCource(Currency.USD)));
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
        long usd = converter.convertAtUSD(Currency.MDL, countMoney);
        long expected = (long) ((usd * provider.getCource(Currency.UAH)));
        long actual = converter.convert(Currency.MDL,Currency.UAH,countMoney);
        assertEquals(expected,actual);

    }
    //END MDL tests convert to X

    //RUB tests convert to X
    @Test
    public void convert_RUB_to_MDL_Test(){

        long usd = converter.convertAtUSD(Currency.RUB, countMoney);
        long expected = (long) ((usd * provider.getCource(Currency.MDL)));
        long actual = converter.convert(Currency.RUB,Currency.MDL,countMoney);
        assertEquals(expected,actual);

    }
    @Test
    public void convert_RUB_to_EUR_Test(){

        long usd = converter.convertAtUSD(Currency.RUB, countMoney);
        long expected = (long) ((usd * provider.getCource(Currency.EUR)));
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

        long usd = converter.convertAtUSD(Currency.RUB, countMoney);
        long expected = (long) ((usd * provider.getCource(Currency.UAH)));
        long actual = converter.convert(Currency.RUB,Currency.UAH,countMoney);
        assertEquals(expected,actual);

    }
    @Test
    public void convert_RUB_to_USD_test(){

        long expected = (long) ((countMoney / provider.getCource(Currency.RUB)));
        long actual = converter.convert(Currency.RUB,Currency.USD, countMoney);

        assertEquals(expected,actual);

    }

    //END RUB tests convert to X

    //UAH tests convert to X
    @Test
    public void convert_UAH_to_EUR_Test(){

        long usd = converter.convertAtUSD(Currency.UAH, countMoney);
        long expected = (long) ((usd * provider.getCource(Currency.EUR)));
        long actual = converter.convert(Currency.UAH,Currency.EUR,countMoney);
        assertEquals(expected,actual);

    }
    @Test
    public void convert_UAH_to_RUB_Test(){

        long usd = converter.convertAtUSD(Currency.UAH, countMoney);
        long expected = (long) ((usd * provider.getCource(Currency.RUB)));
        long actual = converter.convert(Currency.UAH,Currency.RUB,countMoney);
        assertEquals(expected,actual);

    }
    @Test
    public void convert_UAH_to_USD_Test(){

        long usd = converter.convertAtUSD(Currency.UAH, countMoney);
        long expected = (long) ((usd * provider.getCource(Currency.USD)));
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

        long usd = converter.convertAtUSD(Currency.UAH, countMoney);
        long expected = (long) ((usd * provider.getCource(Currency.MDL)));
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

        long usd = converter.convertAtUSD(Currency.USD, countMoney);
        long expected = (long) ((usd * provider.getCource(Currency.MDL)));
        long actual = converter.convert(Currency.USD,Currency.MDL,countMoney);
        assertEquals(expected,actual);
    }
    @Test
    public void convert_USD_to_EUR_Test(){

        long usd = converter.convertAtUSD(Currency.USD, countMoney);
        long expected = (long) ((usd * provider.getCource(Currency.EUR)));
        long actual = converter.convert(Currency.USD,Currency.EUR,countMoney);
        assertEquals(expected,actual);
    }
    @Test
    public void convert_USD_to_RUB_Test(){

        long usd = converter.convertAtUSD(Currency.USD, countMoney);
        long expected = (long) ((usd * provider.getCource(Currency.RUB)));
        long actual = converter.convert(Currency.USD,Currency.RUB,countMoney);
        assertEquals(expected,actual);
    }
    @Test
    public void convert_USD_to_UAH_Test(){

        long usd = converter.convertAtUSD(Currency.USD, countMoney);
        long expected = (long) ((usd * provider.getCource(Currency.UAH)));
        long actual = converter.convert(Currency.USD,Currency.UAH,countMoney);
        assertEquals(expected,actual);
    }

    //END USD tests convert to X

    //EUR tests convert to X
    @Test
    public void convert_EUR_to_USD_Test(){


        long usd = converter.convertAtUSD(Currency.EUR, countMoney);
        long expected = (long) ((usd * provider.getCource(Currency.USD)));
        long actual = converter.convert(Currency.EUR,Currency.USD,countMoney);
        assertEquals(expected,actual);
    }
    @Test
    public void convert_EUR_to_MDL_Test(){

        long usd = converter.convertAtUSD(Currency.EUR, countMoney);
        long expected = (long) ((usd * provider.getCource(Currency.MDL)));
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

        long usd = converter.convertAtUSD(Currency.EUR, countMoney);
        long expected = (long) ((usd * provider.getCource(Currency.RUB)));
        long actual = converter.convert(Currency.EUR,Currency.RUB,countMoney);
        assertEquals(expected,actual);
    }
    @Test
    public void convert_EUR_to_UAH_Test(){

        long usd = converter.convertAtUSD(Currency.EUR, countMoney);
        long expected = (long) ((usd * provider.getCource(Currency.UAH)));
        long actual = converter.convert(Currency.EUR,Currency.UAH,countMoney);
        assertEquals(expected,actual);
    }

    //END EUR tests convert to X




}