package Accounts;

import Exceptions.InsufficientBalanceException;
import Exceptions.InvalidValueException;
import Transaction.TransactionManager;

public class CurrentAccount extends Account {

    // FEES FOR WITHDRAWAL AND TRANSFER METHODS
    private double rate = 3.5;

    public CurrentAccount(String accountNumber, String holder, double balance) {
        super(accountNumber, holder, balance);
    }

    @Override
    public void deposit(double value) {
        if (value > 0){
            balance += value;
            TransactionManager.getInstance().addTransaction(this, value);
        } else {
            throw new InvalidValueException("Invalid value");
        }
    }

    @Override
    public void withdraw(double value) {
        if (value > 0){
            double totalValue = value + rate;
            if (totalValue <= balance){
                balance -= totalValue;
                TransactionManager.getInstance().addTransaction(this, value);
            } else {
                throw new InsufficientBalanceException("Insufficient balance");
            }
        } else {
            throw new InvalidValueException("Invalid value");
        }
    }

    @Override
    public void transfer(double value, Account originAccount,Account destionationAccount) {
        if (value > 0){
            if (originAccount != null && destionationAccount != null) {
                    originAccount.withdraw(value + rate);
                    destionationAccount.deposit(value);
                } else {
                    throw new IllegalArgumentException("Invalid account");
                }
            } else {
            throw new InvalidValueException("Invalid value");
            }
        }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}