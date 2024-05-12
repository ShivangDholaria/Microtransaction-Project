package resources.UnitTests.service;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import dev.transacts.model.Balance;

public class BalanceTest {

    @Test
    public void testGetAmount() {
        Balance balance = new Balance("100.00", "USD", "debit");
        BigDecimal expectedAmount = new BigDecimal("100.00");
        assertEquals(expectedAmount, balance.getAmount());
    }

    @Test
    public void testGetCurrency() {
        Balance balance = new Balance("100.00", "USD", "debit");
        String expectedCurrency = "USD";
        assertEquals(expectedCurrency, balance.getCurrency());
    }

    @Test
    public void testSetCurrency() {
        Balance balance = new Balance("100.00", "USD", "debit");
        String newCurrency = "EUR";
        balance.setCurrency(newCurrency);
        assertEquals(newCurrency, balance.getCurrency());
    }

    @Test
    public void testGetDebitOrCredit() {
        Balance balance = new Balance("100.00", "USD", "debit");
        String expectedDebitOrCredit = "debit";
        assertEquals(expectedDebitOrCredit, balance.getDebitOrCredit());
    }

    @Test
    public void testSetDebitOrCredit() {
        Balance balance = new Balance("100.00", "USD", "debit");
        String newDebitOrCredit = "credit";
        balance.setDebitOrCredit(newDebitOrCredit);
        assertEquals(newDebitOrCredit, balance.getDebitOrCredit());
    }

    @Test
    public void testToString() {
        Balance balance = new Balance("100.00", "USD", "debit");
        String expectedToString = "Balance{amount=100.00, currency='USD', debitOrCredit='debit'}";
        assertEquals(expectedToString, balance.toString());
    }

}
