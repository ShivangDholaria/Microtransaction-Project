package dev.transacts;


import java.util.Currency;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dev.transacts.entity.Currencies;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * The main class of the application.
 */
@SpringBootApplication
public class MainApplication {


    
    public static void main(String[] args) {
        
        //Creating persistence storage before API can be used
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("transaction_project-pu");
        EntityManager em = emf.createEntityManager();

        Set<Currency> currSet = Currency.getAvailableCurrencies(); 
        
        //Adding persistence storage for Currencies
        for(Currency cur : currSet) {
            new Currencies(cur.getCurrencyCode(), cur.getDisplayName());
        }

        SpringApplication.run(MainApplication.class, args);
    }

}
