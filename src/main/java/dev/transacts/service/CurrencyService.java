package dev.transacts.service;

import java.util.List;

import dev.transacts.entity.Currencies;

public interface CurrencyService {
    
    //Save operation
    Currencies saveCurrencies(Currencies currencies);
    
    //Get operation
    List<Currencies> fetchAllCurrencies();

}
