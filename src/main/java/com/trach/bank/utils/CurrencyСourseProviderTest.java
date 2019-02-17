package com.trach.bank.utils;

import com.trach.bank.model.Currency;

import java.util.HashMap;
import java.util.Map;

public class CurrencyСourseProviderTest implements CurrencyСourseProvider{
    @Override
    public float getCource(Currency of) {
        Map<Currency,Float> cources = new HashMap<>();
        cources.put(Currency.EUR,new Float(0.89));
        cources.put(Currency.MDL,new Float(17.10));
        cources.put(Currency.UAH,new Float(27.24));
        cources.put(Currency.USD,new Float(1));
        cources.put(Currency.RUB,new Float(66.29));
        return  cources.get(of).floatValue();

    }
}
