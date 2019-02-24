package com.trach.bank.utils;

import com.trach.bank.model.Currency;

import java.util.HashMap;
import java.util.Map;

public class CurrencyCourseProviderTest implements CurrencyСourseProvider{
    @Override
    public float getCource(Currency of) {
        Map<Currency,Float> cources = new HashMap<>();
        cources.put(Currency.EUR,0.89f);
        cources.put(Currency.MDL,17.10f);
        cources.put(Currency.UAH,27.24f);
        cources.put(Currency.USD,1f);
        cources.put(Currency.RUB,65.37f);
        return  cources.get(of);

    }
}
