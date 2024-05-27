package dev.transacts;


import java.util.Currency;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dev.transacts.entity.Currencies;
import dev.transacts.repository.CurrencyRepository;

/**
 * The main class of the application.
 */
@SpringBootApplication
public class MainApplication implements CommandLineRunner {

    @Autowired
    private CurrencyRepository currencyRepository;
    
    Set<Currency> currSet = Currency.getAvailableCurrencies(); 
    
    public static void main(String[] args) {    
        SpringApplication.run(MainApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        for(Currency cur : currSet) {
            Currencies currencies = new Currencies(cur.getCurrencyCode(), cur.getDisplayName());
            currencyRepository.save(currencies);
        }
    }

}
