package resources.UnitTests.service;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import dev.transacts.entity.User;
import dev.transacts.service.Credit;

public class CreditTest {

    @Test
    public void testCreditAmount() {
        BigDecimal initialBalance = new BigDecimal("100.00");
        
        User user = new User("1", initialBalance);
        
        BigDecimal amountToCredit = new BigDecimal("50.00");
        BigDecimal expectedBalance = initialBalance.add(amountToCredit);

        Credit credit = new Credit();
        credit.creditAmount(user, amountToCredit);

        assertEquals(expectedBalance, user.getBalance());
    }

    @Test
    public void testCreditAmountWithZeroAmount() {
        BigDecimal initialBalance = new BigDecimal("500.00");

        User user = new User("1", initialBalance);

        BigDecimal amountToCredit = BigDecimal.ZERO;
        BigDecimal expectedBalance = initialBalance;

        Credit credit = new Credit();
        credit.creditAmount(user, amountToCredit);

        assertEquals(expectedBalance, user.getBalance());
    }

}
