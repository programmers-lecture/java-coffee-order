package coffee.order.service;

import coffee.order.model.MenuType;
import coffee.order.model.Transaction;
import coffee.order.repository.TransactionRepository;
import coffee.order.view.Order;

public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService() {
        transactionRepository = new TransactionRepository();
    }

    public Transaction createNewTransaction(Order order, MenuService menuService) {
        Transaction transaction = convertToTransaction(order, menuService);
        transactionRepository.addTransaction(transaction);
        return transaction;
    }

    private Transaction convertToTransaction(Order order, MenuService menuService) {
        MenuType menuType = MenuType.findMenuType(order.getMenuType());
        String menuName = menuService.findMenuName(menuType, order.getMenuName());
        int orderQuantity = order.getOrderQuantity();
        int orderAmount = menuService.findMenuPrice(menuType, menuName) * orderQuantity;

        return new Transaction(menuType, menuName, orderQuantity, orderAmount);
    }
}
