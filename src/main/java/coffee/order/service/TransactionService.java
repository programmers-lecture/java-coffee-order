package coffee.order.service;

import coffee.order.model.Transaction;
import coffee.order.repository.TransactionRepository;
import coffee.order.view.Order;

public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService() {
        transactionRepository = new TransactionRepository();
    }

    public void createNewTransaction(Order order, ChoiceConverter converter, MenuService menuService) {
        Transaction transaction = converter.convertToTransaction(order, menuService);
        transactionRepository.addTransaction(transaction);
    }
}
