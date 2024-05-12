package dev.transacts.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 
 */

public class Balance {

    //Variable to set them as requests come in
    BigDecimal amount;
    String currency;
    String debitOrCredit;
    
    //Constructor
    public Balance(String amount, String currency, String debitOrCredit) {
        this.amount = new BigDecimal(amount).setScale(2, RoundingMode.HALF_UP);
        this.currency = currency;
        this.debitOrCredit = debitOrCredit; 
    }

    public void setAmount(String amount) {
        this.amount = new BigDecimal(amount);
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDebitOrCredit() {
        return debitOrCredit;
    }

    public void setDebitOrCredit(String debitOrCredit) {
        this.debitOrCredit = debitOrCredit;
    }

    // toString method
    @Override
    public String toString() {
        return "Balance{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                ", debitOrCredit='" + debitOrCredit + '\'' +
                '}';
    }
}
