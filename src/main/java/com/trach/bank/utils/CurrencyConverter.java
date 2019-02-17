package com.trach.bank.utils;

import com.trach.bank.model.Currency;

public interface CurrencyConverter {
     long convert(Currency of,Currency at,long count);
}
