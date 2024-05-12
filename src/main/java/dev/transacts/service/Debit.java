package dev.transacts.service;

import java.math.BigDecimal;

import dev.transacts.entity.User;

public class Debit {
    
    //User on whom transaction is to be done
    User user;

    public Debit(){
    }


    public boolean debitAmount(User user, BigDecimal amount) {
        
        if(user.getBalance().compareTo(amount)>0) {
            user.setBalance(user.getBalance().subtract(amount));
            return true;
        }
        else    return false;
    }
}
