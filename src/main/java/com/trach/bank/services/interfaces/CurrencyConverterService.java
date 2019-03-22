package com.trach.bank.services.interfaces;

import com.trach.bank.model.Currency;

public interface CurrencyConverterService {
     long convert(Currency of,Currency at,long count);
}
