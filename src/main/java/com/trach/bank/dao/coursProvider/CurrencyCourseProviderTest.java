package com.trach.bank.dao.coursProvider;

import com.trach.bank.model.Currency;

import java.util.HashMap;
import java.util.Map;

public class CurrencyCourseProviderTest implements CurrencyСourseProvider{
    @Override
    public float getCourse(Currency of) {
        Map<Currency,Float> courses = new HashMap<>();
        courses.put(Currency.EUR,0.89f);
        courses.put(Currency.MDL,17.10f);
        courses.put(Currency.UAH,27.24f);
        courses.put(Currency.USD,1f);
        courses.put(Currency.RUB,65.37f);
        return  courses.get(of);

    }
}
