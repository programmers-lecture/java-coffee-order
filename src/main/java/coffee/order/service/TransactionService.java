package coffee.order.service;

import coffee.order.model.Transaction;
import coffee.order.repository.TransactionRepository;
import coffee.order.view.MenuChoice;

public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService() {
        transactionRepository = new TransactionRepository();
    }

    public void createNewTransaction(MenuChoice menuChoice, ChoiceConverter converter, MenuService menuService) {
        Transaction transaction = converter.convertToTransaction(menuChoice, menuService);
        transactionRepository.addTransaction(transaction);
    }
}
