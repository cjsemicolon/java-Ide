package bankAccount;

public class Account {

    private String name;
    private int balance;
    private String pin;
    private int number;

    public Account(String name, int number, String pin) {
        this.name = name;
        this.number = number;
        this.pin = pin;
        this.balance = 0;
    }

    public void deposit(int amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero.");
        }

        balance += amount;
    }

    public void withdraw(int amount, String pin) {

        if (!this.pin.equals(pin)) {
            throw new IllegalArgumentException("Incorrect PIN.");
        }

        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero.");
        }

        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds.");
        }

        balance -= amount;
    }

    public int checkBalance(String pin) {

        if (!this.pin.equals(pin)) {
            throw new IllegalArgumentException("Incorrect PIN.");
        }

        return balance;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}