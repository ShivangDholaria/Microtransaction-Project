package dev.transacts.service;

import java.math.BigDecimal;

import dev.transacts.entity.User;

public class Credit {
        //User on whom transaction is to be done
    User user;

    public Credit(){}


    public void creditAmount(User user, BigDecimal amount) {
        user.setBalance(user.getBalance().add(amount));
    }
}
