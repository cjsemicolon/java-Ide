package bankAccount;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankTest {

    @Test
    public void testThatBankExists() {
        Bank bank = new Bank("GTBank");
        assertNotNull(bank);
    }

    @Test
    public void testRegisterCustomerCreatesAccount() {
        Bank bank = new Bank("GTBank");

        Account account = bank.registerCustomer("John", "1234");

        assertNotNull(account);
    }

    @Test
    public void testRegisterCustomerAssignsAccountNumber() {
        Bank bank = new Bank("GTBank");

        Account account = bank.registerCustomer("John", "1234");

        assertEquals(1001, account.getNumber());
    }

    @Test
    public void testSecondCustomerGetsNextAccountNumber() {
        Bank bank = new Bank("GTBank");

        bank.registerCustomer("John", "1234");
        Account account = bank.registerCustomer("Mary", "5678");

        assertEquals(1002, account.getNumber());
    }

    @Test
    public void testDepositIncreasesBalance() {
        Bank bank = new Bank("GTBank");

        Account account = bank.registerCustomer("John", "1234");

        bank.deposit(account.getNumber(), 500);

        assertEquals(500, bank.checkBalance(account.getNumber(), "1234"));
    }

    @Test
    public void testWithdrawReducesBalance() {
        Bank bank = new Bank("GTBank");

        Account account = bank.registerCustomer("John", "1234");

        bank.deposit(account.getNumber(), 500);
        bank.withdraw(account.getNumber(), 200, "1234");

        assertEquals(300, bank.checkBalance(account.getNumber(), "1234"));
    }

    @Test
    public void testTransferMovesMoneyBetweenAccounts() {
        Bank bank = new Bank("GTBank");

        Account sender = bank.registerCustomer("John", "1234");
        Account receiver = bank.registerCustomer("Mary", "5678");

        bank.deposit(sender.getNumber(), 1000);

        bank.transfer(sender.getNumber(),
                receiver.getNumber(),
                400,
                "1234");

        assertEquals(600, bank.checkBalance(sender.getNumber(), "1234"));
        assertEquals(400, bank.checkBalance(receiver.getNumber(), "5678"));
    }

    @Test
    public void testFindAccountReturnsCorrectAccount() {
        Bank bank = new Bank("GTBank");

        Account account = bank.registerCustomer("John", "1234");

        assertEquals(account, bank.findAccount(account.getNumber()));
    }

    @Test
    public void testFindAccountThrowsExceptionIfAccountDoesNotExist() {
        Bank bank = new Bank("GTBank");

        assertThrows(IllegalArgumentException.class, () -> {
            bank.findAccount(9999);
        });
    }

    @Test
    public void testCheckBalanceWithWrongPinThrowsException() {
        Bank bank = new Bank("GTBank");

        Account account = bank.registerCustomer("John", "1234");

        assertThrows(IllegalArgumentException.class, () -> {
            bank.checkBalance(account.getNumber(), "0000");
        });
    }

    @Test
    public void testDepositNegativeAmountThrowsException() {
        Bank bank = new Bank("GTBank");

        Account account = bank.registerCustomer("John", "1234");

        assertThrows(IllegalArgumentException.class, () -> {
            bank.deposit(account.getNumber(), -500);
        });
    }

    @Test
    public void testWithdrawWithWrongPinThrowsException() {
        Bank bank = new Bank("GTBank");

        Account account = bank.registerCustomer("John", "1234");

        bank.deposit(account.getNumber(), 500);

        assertThrows(IllegalArgumentException.class, () -> {
            bank.withdraw(account.getNumber(), 200, "9999");
        });
    }

    @Test
    public void testRemoveAccountDeletesAccount() {
        Bank bank = new Bank("GTBank");

        Account account = bank.registerCustomer("John", "1234");

        bank.removeAccount(account.getNumber(), "1234");

        assertThrows(IllegalArgumentException.class, () -> {
            bank.findAccount(account.getNumber());
        });
    }
}