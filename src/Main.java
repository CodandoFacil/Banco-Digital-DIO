import Accounts.CurrentAccount;
import Transaction.TransactionManager;

public class Main {

    public static void main(String[] args) {
        CurrentAccount c1 = new CurrentAccount("122", "J", 120);
        CurrentAccount c2 = new CurrentAccount("123", "R", 100);
        c1.transfer(50, c1, c2);
        System.out.println(TransactionManager.getInstance().transactionsView(c1));
    }
}
