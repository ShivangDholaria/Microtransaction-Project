package dev.transacts.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.transacts.entity.Currencies;
import dev.transacts.repository.CurrencyRepository;
import dev.transacts.service.CurrencyService;

@Service
public class CurrencyServiceImpl implements CurrencyService{

    @Autowired
    private CurrencyRepository currencyRepository;

    @Override
    public List<Currencies> fetchAllCurrencies() {
        return (List<Currencies>) currencyRepository.findAll();
    }

    @Override
    public Currencies saveCurrencies(Currencies currencies) {
        return currencyRepository.save(currencies);
    }
    
}
