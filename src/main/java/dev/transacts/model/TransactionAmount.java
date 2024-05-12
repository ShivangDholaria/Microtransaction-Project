package dev.transacts.model;

public class TransactionAmount {
    //Variable to set them as requests come in
    String amount;
    String currency;
    String debitOrCredit;
    
    //Constructor
    public TransactionAmount(String amount, String currency, String debitOrCredit) {
        this.amount = amount;
        this.currency = currency;
        this.debitOrCredit = debitOrCredit; 
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAmount() {
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
