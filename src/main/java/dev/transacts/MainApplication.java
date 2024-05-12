package dev.transacts;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dev.transacts.entity.User;

/**
 * The main class of the application.
 */
@SpringBootApplication
public class MainApplication {

    //
    static User user = User.getInstance();
    
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
            
        user.addUser(UUID.randomUUID().toString(), BigDecimal.valueOf(0)); // Fixed code
        user.addUser(UUID.randomUUID().toString(), BigDecimal.valueOf(0)); // Fixed code
        user.addUser(UUID.randomUUID().toString(), BigDecimal.valueOf(0)); // Fixed code
        user.addUser("8e306590-7c6b-4ca2-a6ba-14073c329998", BigDecimal.valueOf(0)); // Fixed code
        user.addUser("8786e2f9-d472-46a8-958f-d659880e723d", BigDecimal.valueOf(1000)); // Fixed code
    }

}
