package bankAccount;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    @Test
    public void testThatAccountExists() {
        AccountTest account = new AccountTest();
        assertNotNull(account);
    }

    @Test
    public void testThatNewAccountHasZeroBalance() {
        Account account = new Account();
        assertEquals(0, account.getBalance("1234"));
    }

    @Test
    public void testDeposit200IncreasesBalanceTo200() {
        Account account = new Account();

        account.deposit(200);

        assertEquals(200, account.getBalance("1234"));
    }

    @Test
    public void testNegativeDepositDoesNotChangeBalance() {
        Account account = new Account();

        account.deposit(-50);

        assertEquals(0, account.getBalance("1234"));
    }

    @Test
    public void testWithdrawFromZeroBalanceDoesNotChangeBalance() {
        Account account = new Account();

        account.withdraw(50, "1234");

        assertEquals(0, account.getBalance("1234"));
    }

    @Test
    public void testWithdraw200From500WithCorrectPinLeaves300() {
        Account account = new Account();

        account.deposit(500);
        account.withdraw(200, "1234");

        assertEquals(300, account.getBalance("1234"));
    }

    @Test
    public void testWithdrawWithWrongPinDoesNotChangeBalance() {
        Account account = new Account();

        account.deposit(500);
        account.withdraw(200, "1111");

        assertEquals(500, account.getBalance("1234"));
    }

    @Test
    public void testCorrectPinCanViewBalance() {
        Account account = new Account();

        account.deposit(200);

        assertEquals(200, account.getBalance("1234"));
    }

    @Test
    public void testWrongPinCannotViewBalance() {
        Account account = new Account();

        account.deposit(200);

        assertEquals(-1, account.getBalance("9999"));
    }
    
}