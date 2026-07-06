package bankAccount;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    @Test
    public void testThatAccountExists() {
        Account account = new Account("John", 1001, "1234");
        assertNotNull(account);
    }

    @Test
    public void testThatNewAccountHasZeroBalance() {
        Account account = new Account("John", 1001, "1234");
        assertEquals(0, account.checkBalance("1234"));
    }

    @Test
    public void testDeposit200IncreasesBalanceTo200() {
        Account account = new Account("John", 1001, "1234");

        account.deposit(200);

        assertEquals(200, account.checkBalance("1234"));
    }

    @Test
    public void testNegativeDepositThrowsException() {
        Account account = new Account("John", 1001, "1234");

        assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-50);
        });
    }

    @Test
    public void testWithdrawFromZeroBalanceThrowsException() {
        Account account = new Account("John", 1001, "1234");

        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(50, "1234");
        });
    }

    @Test
    public void testWithdraw200From500WithCorrectPinLeaves300() {
        Account account = new Account("John", 1001, "1234");

        account.deposit(500);
        account.withdraw(200, "1234");

        assertEquals(300, account.checkBalance("1234"));
    }

    @Test
    public void testWithdrawWithWrongPinThrowsException() {
        Account account = new Account("John", 1001, "1234");

        account.deposit(500);

        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(200, "1111");
        });
    }

    @Test
    public void testCorrectPinCanViewBalance() {
        Account account = new Account("John", 1001, "1234");

        account.deposit(200);

        assertEquals(200, account.checkBalance("1234"));
    }

    @Test
    public void testWrongPinCannotViewBalance() {
        Account account = new Account("John", 1001, "1234");

        account.deposit(200);

        assertThrows(IllegalArgumentException.class, () -> {
            account.checkBalance("9999");
        });
    }
}