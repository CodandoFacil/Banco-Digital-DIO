package Transaction;

import java.time.LocalDateTime;

public final class Transaction {
    private final double value;
    private final LocalDateTime date;

    public Transaction(double value) {
        this.value = value;
        this.date = LocalDateTime.now();
    }

    public double getValue() {
        return value;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Transaction: " + "value=" + value + " | date=" + date + "\n";
    }
}
