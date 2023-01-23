package test;

import main.Account;
import org.junit.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.valueOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AccountTest {

    private static final int TEST_ACCOUNT = 123456789;
    private static final int TEST_PIN = 1234;
    private static final BigDecimal TEST_BALANCE = valueOf(100);
    private static final int TEST_ACCOUNT_2 = 987654321;
    private static final int TEST_PIN_2 = 4321;
    private static final BigDecimal TEST_BALANCE_2 = valueOf(200);

    @Test
    public void canCreateAccount_getSetFields() {
        Account account = getAccount();
        assertAccountFields(account, TEST_ACCOUNT, TEST_PIN, TEST_BALANCE);
        setNewAccountFields(account);
        assertAccountFields(account, TEST_ACCOUNT_2, TEST_PIN_2, TEST_BALANCE_2);
    }

    @Test
    public void validatePin() {
        Account account = getAccount();
        assertTrue(account.validatePin(TEST_PIN));
        assertFalse(account.validatePin(TEST_PIN_2));
    }

    private Account getAccount() {
        return new Account(TEST_ACCOUNT, TEST_PIN, TEST_BALANCE);
    }

    private void setNewAccountFields(Account account) {
        account.setAccountNumber(TEST_ACCOUNT_2);
        account.setPin(TEST_PIN_2);
        account.setBalance(TEST_BALANCE_2);
    }

    private void assertAccountFields(Account account, int accountNumber, int pin, BigDecimal balance) {
        assertEquals(accountNumber, account.getAccountNumber());
        assertEquals(pin, account.getPin());
        assertEquals(balance, account.getBalance());
    }
}
