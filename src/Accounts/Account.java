package Accounts;
import Exceptions.InvalidValueException;

public abstract class Account {

    protected final String accountNumber;
    protected final String holder;
    protected double balance;

    public Account(String accountNumber, String holder, double balance) {
        this.accountNumber = accountNumber;
        this.holder = holder;
        // CHECKING IF PAST BALANCE IS GREATER THAN 0
        if (balance > 0) {
            this.balance = balance;
        } else {
            throw new InvalidValueException("Invalid value");
        }
    }

    public abstract void deposit(double value);

    public abstract void withdraw(double value);

    public abstract void transfer(double value, Account originAccount, Account destionationAccount);

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolder() {
        return holder;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
