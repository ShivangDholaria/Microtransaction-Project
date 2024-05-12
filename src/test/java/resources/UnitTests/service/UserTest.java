package resources.UnitTests.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import dev.transacts.entity.User;


public class UserTest {

    private static User instance;

    @Before
    public void setUp() {
        instance = User.getInstance();
        instance.addUser("12345", new BigDecimal("100.00"));
    }

    @Test
    public void testGetUserID() {
        String expectedUserID = "12345";
        String actualUserID = instance.getUser(expectedUserID).getUserID();
        assertEquals(expectedUserID, actualUserID);
    }

    @Test
    public void testGetBalance() {
        BigDecimal expectedBalance = new BigDecimal("100.00");
        BigDecimal actualBalance = instance.getUser("12345").getBalance();
        assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void testGetInstance() {
        User instance1 = User.getInstance();
        User instance2 = User.getInstance();
        assertSame(instance1, instance2);
    }

    @Test
    public void testGetUserListLength() {
        int expectedLength = 1;
        int actualLength = instance.getUserListLength();
        assertEquals(expectedLength, actualLength);
    }

}