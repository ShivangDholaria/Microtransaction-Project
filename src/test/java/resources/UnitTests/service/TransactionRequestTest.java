package resources.UnitTests.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import dev.transacts.model.TransactionAmount;
import dev.transacts.model.TransactionRequest;

public class TransactionRequestTest {

    @Test
    public void testGetMessageId() {
        TransactionRequest request = new TransactionRequest("123", "user123", new TransactionAmount("100", "USD", "DEBIT"));
        assertEquals("123", request.getMessageId());
    }

    @Test
    public void testGetUserId() {
        TransactionRequest request = new TransactionRequest("123", "user123", new TransactionAmount("100", "USD", "DEBIT"));
        assertEquals("user123", request.getUserId());
    }

    @Test
    public void testToString() {
        TransactionRequest request = new TransactionRequest("123", "user123", new TransactionAmount("100", "USD", "DEBIT"));
        String expected = "AuthorizationRequest{messageId='123', userId='user123', transactionAmount=Balance{amount=100, currency='USD', debitOrCredit='DEBIT'}}";
        assertEquals(expected, request.toString());
    }
}