package com.trach.bank.utils;

import com.trach.bank.model.Currency;

public class CurrencyConverterImpl implements CurrencyConverter {
    private CurrencyСourseProvider provider;

    public CurrencyConverterImpl(CurrencyСourseProvider provider) {
        this.provider = provider;
    }

    @Override
    public long convert(Currency of, Currency at,long count) {
       long countAtUsd =  convertAtUSD(of, count);
        return (long) (countAtUsd * provider.getCource(at));


    }

    long convertAtUSD(Currency of,long count){
      return (long) (count /  provider.getCource(of));
    }
}