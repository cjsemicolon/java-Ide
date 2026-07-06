package bankAccount;

import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList<Account> accounts;
    private int nextAccountNumber = 1001;

    public Bank(String name) {
        this.name = name;
        accounts = new ArrayList<>();
    }

    public Account registerCustomer(String name, String pin) {

        Account account = new Account(name, nextAccountNumber, pin);

        accounts.add(account);
        nextAccountNumber++;

        return account;
    }

    public Account findAccount(int accountNumber) {

        for (Account account : accounts) {
            if (account.getNumber() == accountNumber) {
                return account;
            }
        }

        throw new IllegalArgumentException("Account not found.");
    }

    public void deposit(int accountNumber, int amount) {

        Account account = findAccount(accountNumber);
        account.deposit(amount);
    }

    public void withdraw(int accountNumber, int amount, String pin) {

        Account account = findAccount(accountNumber);
        account.withdraw(amount, pin);
    }

    public void transfer(int senderNumber, int receiverNumber, int amount, String pin) {

        Account sender = findAccount(senderNumber);
        Account receiver = findAccount(receiverNumber);

        sender.withdraw(amount, pin);
        receiver.deposit(amount);
    }

    public int checkBalance(int accountNumber, String pin) {

        Account account = findAccount(accountNumber);
        return account.checkBalance(pin);
    }

    public void removeAccount(int accountNumber, String pin) {

        Account account = findAccount(accountNumber);

        account.checkBalance(pin);

        accounts.remove(account);
    }
}