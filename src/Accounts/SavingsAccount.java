package Accounts;

import Exceptions.InsufficientBalanceException;
import Exceptions.InvalidValueException;
import Transaction.TransactionManager;

public class SavingsAccount extends Account{



    public SavingsAccount(String accountNumber, String holder, double balance) {
        super(accountNumber, holder, balance);
    }

    @Override
    public void deposit(double value) {
        if (value > 0){
            double yieldRate = 0.05 * getBalance();
            balance += value + yieldRate;
            TransactionManager.getInstance().addTransaction(this, value);
        } else {
            throw new InvalidValueException("Invalid value");
        }
    }

    @Override
    public void withdraw(double value) {
        if (value > 0){
            if (value <= balance){
                balance -= value;
                TransactionManager.getInstance().addTransaction(this, value);
            } else {
                throw new InsufficientBalanceException("Insufficient balance");
            }
        } else {
            throw new InvalidValueException("Invalid value");
        }
    }

    @Override
    public void transfer(double value, Account originAccount,  Account destionationAccount) {
        if (value > 0){
            if (originAccount != null && destionationAccount != null) {
                originAccount.withdraw(value);
                destionationAccount.deposit(value);
            } else {
                throw new IllegalArgumentException("Invalid account");
            }
        } else {
            throw new InvalidValueException("Invalid value");
        }
    }
}
