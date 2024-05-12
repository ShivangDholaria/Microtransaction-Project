package resources.UnitTests.service;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import dev.transacts.entity.User;
import dev.transacts.service.Debit;

public class DebitTest {
    
    @Test
    public void DebitTestisValid() {
        User user = new User("1", new BigDecimal(1000));
        Debit debit = new dev.transacts.service.Debit();
        debit.debitAmount(user, new BigDecimal(100));
        assertEquals(new BigDecimal(900), user.getBalance());
    }

    @Test
    public void DebitTestNotValid() {
        User user = new User("1", new BigDecimal(1000));
        Debit debit = new dev.transacts.service.Debit();
        debit.debitAmount(user, new BigDecimal(2000));
        assertEquals(new BigDecimal(1000), user.getBalance());
    }
}
