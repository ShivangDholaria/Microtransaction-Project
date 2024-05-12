package resources.UnitTests.service;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import dev.transacts.entity.Events;

public class EventsTest {

    @Test
    public void testGetAction() {
        Events events = new Events();
        events.setAction("deposit");
        assertEquals("deposit", events.getAction());
    }

    @Test
    public void testGetMessageID() {
        Events events = new Events();
        events.setMessageID("123456");
        assertEquals("123456", events.getMessageID());
    }

    @Test
    public void testGetUserID() {
        Events events = new Events();
        events.setUserID("user123");
        assertEquals("user123", events.getUserID());
    }

    @Test
    public void testGetDebitOrCredit() {
        Events events = new Events();
        events.setDebitOrCredit("credit");
        assertEquals("credit", events.getDebitOrCredit());
    }

    @Test
    public void testGetTransactionAmount() {
        Events events = new Events();
        BigDecimal amount = new BigDecimal("100.00");
        events.setTransactionAmount(amount);
        assertEquals(amount, events.getTransactionAmount());
    }

    @Test
    public void testGetResponseCode() {
        Events events = new Events();
        events.setResponseCode("200");
        assertEquals("200", events.getResponseCode());
    }

    @Test
    public void testGetBalance() {
        Events events = new Events();
        events.setBalance("1000.00");
        assertEquals("1000.00", events.getBalance());
    }

    @Test
    public void testGetTimeStamp() {
        Events events = new Events();
        events.setTimeStamp("2022-01-01 10:00:00");
        assertEquals("2022-01-01 10:00:00", events.getTimeStamp());
    }
}