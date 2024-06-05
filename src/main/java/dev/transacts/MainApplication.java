package dev.transacts;


import java.math.BigDecimal;
import java.util.Currency;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dev.transacts.entity.Currencies;
import dev.transacts.entity.User;
import dev.transacts.repository.CurrencyRepository;
import dev.transacts.repository.UserRepository;

/**
 * The main class of the application.
 */
@SpringBootApplication
public class MainApplication implements CommandLineRunner {

    @Autowired
    private CurrencyRepository currencyRepository;

    @Autowired
    private UserRepository userRepository;
    
    Set<Currency> currSet = Currency.getAvailableCurrencies(); 
    
    public static void main(String[] args) {    
        SpringApplication.run(MainApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // Adding all currencies in the table
        for(Currency cur : currSet) {
            currencyRepository.save(new Currencies(cur.getCurrencyCode(), cur.getDisplayName()));
        }

        if(userRepository.count() < 10) {            
            for (int i = 0; i < 10; i++) {
                //Generating Random initial balances
                BigDecimal bal = new BigDecimal((new Random().nextDouble(10000, 20000)));
                int bas = 0;
                switch (new Random().nextInt(1,4)) {
                    case 1:
                        bas = 10;
                        break;
    
                    case 2:
                        bas = 100;
                        break;                
                        
                    case 3:
                        bas = 1000;
                        break;                
                        
                    case 4:
                        bas = 10000;
                        break;                
                        
                    default:
                        break;
                }
                
                BigDecimal remainder = bal.remainder(new BigDecimal(bas));
                bal = bal.subtract(remainder);

                //Creating UserID
                String UserID = UUID.randomUUID().toString();
            
                //Creating user in DB
                userRepository.save(new User(UserID, bal));
            }
        }

        
    }

}
