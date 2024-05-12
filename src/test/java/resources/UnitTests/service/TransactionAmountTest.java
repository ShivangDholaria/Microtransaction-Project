package resources.UnitTests.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import dev.transacts.model.TransactionAmount;


public class TransactionAmountTest {

    @Test
    public void testGetAmount() {
        TransactionAmount transactionAmount = new TransactionAmount("100", "USD", "debit");
        assertEquals("100", transactionAmount.getAmount());
    }

    @Test
    public void testGetCurrency() {
        TransactionAmount transactionAmount = new TransactionAmount("100", "USD", "debit");
        assertEquals("USD", transactionAmount.getCurrency());
    }

    @Test
    public void testGetDebitOrCredit() {
        TransactionAmount transactionAmount = new TransactionAmount("100", "USD", "debit");
        assertEquals("debit", transactionAmount.getDebitOrCredit());
    }

    @Test
    public void testToString() {
        TransactionAmount transactionAmount = new TransactionAmount("100", "USD", "debit");
        String expectedString = "Balance{amount=100, currency='USD', debitOrCredit='debit'}";
        assertEquals(expectedString, transactionAmount.toString());
    }
}