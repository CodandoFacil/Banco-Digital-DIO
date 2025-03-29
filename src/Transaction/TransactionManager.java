package Transaction;

import Accounts.Account;

import java.util.*;

public final class TransactionManager {
    private static TransactionManager instance;
    private Map<Account, List<Transaction>> transactions;

    private TransactionManager() {
        this.transactions = new LinkedHashMap<>();
    }

    public static TransactionManager getInstance(){
        if (instance == null){
            instance = new TransactionManager();
        }
        return instance;
    }

    public void addTransaction(Account account, double value){
        Transaction transaction = new Transaction(value);
        if (transactions.containsKey(account)){
            transactions.get(account).add(transaction);
        } else {
            List<Transaction> transactionsList = new ArrayList<>();
            transactionsList.add(transaction);
            transactions.put(account, transactionsList);
        }
    }

    public List<Transaction> transactionsView(Account account){
        // RETURNS AN EMPTY LIST IF THERE ARE NO TRANSACTIONS
        return transactions.getOrDefault(account, Collections.emptyList());
    }
}
