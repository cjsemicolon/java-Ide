package bankAccount;

public class Account {

    private int balance;
    private String pin = "1234";

    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(int amount, String pin) {
        if (isCorrectPin(pin) && amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    public int getBalance(String pin) {
        if (isCorrectPin(pin)) {
            return balance;
        }
        return -1;
    }

    private boolean isCorrectPin(String pin) {
        return this.pin.equals(pin);
    }
}