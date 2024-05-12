package resources.UnitTests.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import dev.transacts.model.Balance;
import dev.transacts.model.ValidTransactionRequest;


public class ValidTransactionRequestTest {

    Balance b = new Balance("100", "USD", null);

    @Test
    public void testGetMessageId() {
        String messageId = "123";
        ValidTransactionRequest request = new ValidTransactionRequest(messageId, "user1", b);
        assertEquals(messageId, request.getMessageId());
    }

    @Test
    public void testGetUserId() {
        String userId = "user1";
        ValidTransactionRequest request = new ValidTransactionRequest("123", userId, b);
        assertEquals(userId, request.getUserId());
    }

    @Test
    public void testToString() {
        ValidTransactionRequest request = new ValidTransactionRequest("123", "user1", b);
        String expectedString = "AuthorizationRequest{messageId='123', userId='user1', transactionAmount=Balance{amount=100.00, currency='USD', debitOrCredit='null'}}";
        assertEquals(expectedString, request.toString());
    }
}