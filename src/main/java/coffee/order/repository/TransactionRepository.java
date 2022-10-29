package coffee.order.repository;

import coffee.order.model.Transaction;

import java.util.HashMap;

public class TransactionRepository {
    private final HashMap<Long, Transaction> transactionDatabase;

    private Long transactionIndex = 0L;

    public TransactionRepository() {
        transactionDatabase = new HashMap<>();
    }

    public void addTransaction(Transaction transaction) {
        transactionDatabase.put(++transactionIndex, transaction);
    }

    public HashMap<Long, Transaction> getTransactionDatabase() {
        return transactionDatabase;
    }
}
