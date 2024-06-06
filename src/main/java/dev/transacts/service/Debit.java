package dev.transacts.service;

import java.math.BigDecimal;

import dev.transacts.entity.User;

public class Debit {
    
    public Debit(){
    }

    public boolean debitAmount(User user, BigDecimal amount) {
        
        if(user.getBalance().compareTo(amount)>0) {
            user.setBalance(user.getBalance().subtract(amount));
            return true;
        }
        else    
            return false;
    }
}
