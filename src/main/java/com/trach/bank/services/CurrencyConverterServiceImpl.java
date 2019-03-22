package com.trach.bank.services;

import com.trach.bank.model.Currency;
import com.trach.bank.services.interfaces.CurrencyConverterService;
import com.trach.bank.dao.coursProvider.CurrencyСourseProvider;

public class CurrencyConverterServiceImpl implements CurrencyConverterService {
    private CurrencyСourseProvider provider;

    public CurrencyConverterServiceImpl(CurrencyСourseProvider provider) {
        this.provider = provider;
    }

    @Override
    public long convert(Currency of, Currency at,long count) {
        if(of.equals(at)) return count;
       long countAtEUR =  convertAtEUR(of, count);
        return (long) (countAtEUR * provider.getCourse(at));

    }

    long convertAtEUR(Currency of, long count){
      return (long) (count /  provider.getCourse(of));
    }
}